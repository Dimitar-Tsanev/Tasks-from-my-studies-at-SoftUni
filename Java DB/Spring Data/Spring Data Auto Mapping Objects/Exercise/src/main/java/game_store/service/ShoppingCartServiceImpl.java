package game_store.service;

import game_store.data.entities.Game;
import game_store.data.entities.ShoppingCart;
import game_store.data.repositories.GameRepository;
import game_store.data.repositories.ShoppingCartRepository;
import game_store.service.interfaces.ShoppingCartService;
import game_store.service.interfaces.UserService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;


@Service
public class ShoppingCartServiceImpl  implements ShoppingCartService {

    private final UserService userService;
    private final GameRepository gameRepository;
    private final ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartServiceImpl(UserService userService,
                                   GameRepository gameRepository,
                                   ShoppingCartRepository shoppingCartRepository){

        this.userService = userService;
        this.gameRepository = gameRepository;
        this.shoppingCartRepository = shoppingCartRepository;
    }

    @Transactional
    @Override
    public String addItem ( String itemName ) {
        if ( !userService.isUserLoggedIn () ){
            return "No user logged in";
        }

        if(userService.isUserHaveGame(itemName)){
            return "User already has a game";
        }

        ShoppingCart shoppingCart = shoppingCartRepository.findByUserEmail ( userService.getUserEmail () );

        Game game = gameRepository.findByTitle ( itemName );

        shoppingCart.addGames (game);
        shoppingCartRepository.saveAndFlush ( shoppingCart );

        return game.getTitle () + " added to cart.";
    }

    @Transactional
    @Override
    public String removeItem ( String itemName ) {
        if ( !userService.isUserLoggedIn () ){
            return "No user logged in";
        }
        ShoppingCart shoppingCart = shoppingCartRepository.findByUserEmail ( userService.getUserEmail () );
        Game game = gameRepository.findByTitle ( itemName );

        shoppingCart.removeGame ( game );

        shoppingCartRepository.save ( shoppingCart );

        return " removed from cart.";
    }

    @Transactional
    @Override
    public String buyItems () {
        if ( userService.isUserLoggedIn () ){
            ShoppingCart shoppingCart = shoppingCartRepository.findByUserEmail ( userService.getUserEmail () );
            Set<String> games = shoppingCart.getGames ().stream( ).map ( Game::getTitle ).collect ( Collectors.toSet () );
            shoppingCart.buyItems ();
            shoppingCartRepository.saveAndFlush ( shoppingCart );
            userService.save();

            StringBuilder sb = new StringBuilder ();

            games.forEach ( g-> sb.append ( 	String.format ( "\t-%s", g)).append ( System.lineSeparator () ) );

            return String.format ( "Successfully bought games:%n%s", sb ) ;
        }
        return "No user logged in";
    }
}
