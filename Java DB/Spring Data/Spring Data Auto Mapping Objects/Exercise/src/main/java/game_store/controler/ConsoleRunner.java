package game_store.controler;

import game_store.data.entities.DTOs.CreateGameDTO;
import game_store.data.entities.DTOs.CreateUserDTO;
import game_store.data.entities.DTOs.EditGameDTO;
import game_store.service.interfaces.GameService;
import game_store.service.interfaces.ShoppingCartService;
import game_store.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.stream.Collectors;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private static final BufferedReader READER = new BufferedReader ( new InputStreamReader ( System.in ) );
    private final UserService userService;
    private final GameService gameService;
    private final ShoppingCartService shoppingCartService;

    @Autowired
    public ConsoleRunner ( UserService userService, GameService gameService, ShoppingCartService shoppingCartService ) {
        this.gameService = gameService;
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
    }

    @Override
    public void run ( String... args ) throws Exception {

        String[] commandData = READER.readLine ( ).split ( "\\|" );

        while (!"stop".equalsIgnoreCase ( commandData[0] )) {

            switch (commandData[0].toUpperCase ( )) {
                case "REGISTERUSER":
                    CreateUserDTO createUserDTO = new CreateUserDTO(
                            commandData[1], commandData[2], commandData[3], commandData[4]
                    );
                    System.out.println ( userService.registerUser ( createUserDTO ));
                    break;

                case "LOGINUSER":
                    System.out.println ( userService.loginUser ( commandData[1], commandData[2] ));
                    break;
                case "LOGOUT":
                    System.out.println ( userService.logoutUser () );
                    break;
                case "ALLGAMES":
                    gameService.getAllGames ().forEach ( System.out::println );
                    break;
                case "DETAILGAME":
                    System.out.println ( gameService.getGameDetails ( commandData[1] ) );
                    break;
                case "OWNEDGAMES":
                    System.out.println ( userService.getOwnedGames ());
                    break;
                case "ADDITEM":
                    System.out.println ( shoppingCartService.addItem ( commandData[1] ) );
                    break;
                case "REMOVEITEM":
                    System.out.println ( shoppingCartService.removeItem ( commandData[1] ) );
                    break;
                case "BUYITEM":
                    System.out.println (shoppingCartService.buyItems () );
                    break;
                case "ADDGAME":
                    System.out.println ( gameService.addGame ( new CreateGameDTO (
                            commandData[1],
                            BigDecimal.valueOf ( Double.parseDouble (commandData[2])),
                            Double.parseDouble (commandData[3]),
                            commandData[4], commandData[5],commandData[6],
                            LocalDate.parse ( commandData[7], DateTimeFormatter.ofPattern ( "dd-MM-yyyy" ) )

                    ) ) );
                    break;
                case "EDITGAME":
                    System.out.println ( gameService.editGame ( new EditGameDTO (
                            Long.parseLong ( commandData[1] ),
                            Arrays.stream( commandData ).skip ( 2 ).collect( Collectors.toSet())
                    ) ) );
                    break;
                case "DELETEGAME":
                    System.out.println ( gameService.deleteGame ( Long.parseLong ( commandData[1] ) ) );
                    break;

            }
            commandData = READER.readLine ( ).split ( "\\|" );
        }

    }
}
