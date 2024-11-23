package game_store.service;

import game_store.data.entities.DTOs.*;
import game_store.data.entities.Game;
import game_store.data.repositories.GameRepository;
import game_store.service.interfaces.GameService;
import game_store.service.interfaces.UserService;
import game_store.util.interfacces.ValidatorUtil;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;

    public GameServiceImpl ( GameRepository gameRepository,
                             UserService userService,
                             ModelMapper modelMapper,
                             ValidatorUtil validatorUtil ) {

        this.gameRepository = gameRepository;
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
    }

    @Override
    public Set<ShortGameInfoDTO> getAllGames () {
        return gameRepository.getAll ( ).stream ( )
                .map ( g -> modelMapper.map ( g, ShortGameInfoDTO.class ) )
                .collect ( Collectors.toSet ( ) );
    }

    @Override
    public GameFullInfo getGameDetails ( String gameTitle ) {
        return modelMapper.map ( gameRepository.findByTitle ( gameTitle ), GameFullInfo.class );
    }

    @Override
    public String addGame ( CreateGameDTO createGameDTO ) {
        if ( !userService.isCurrentUserAdmin ( ) ) {
            return "You are not allowed to add this game";
        }

        Set<ConstraintViolation<CreateGameDTO>> violations = validatorUtil.validate ( createGameDTO );

        if ( !violations.isEmpty ( ) ){
            return violations.stream ( )
                    .map ( ConstraintViolation::getMessage )
                    .collect ( Collectors.joining ( System.lineSeparator ( ) ) );
        }
        gameRepository.save ( modelMapper.map ( createGameDTO, Game.class ) );

        return String.format ( "Added %s", createGameDTO.getTitle ( ) );
    }

    @Override
    public String editGame ( EditGameDTO editGameDTO ) {
        if ( !userService.isCurrentUserAdmin ( ) ) {
            return "You are not allowed to edit game";
        }
        if ( gameRepository.findById ( editGameDTO.getId ( ) ).isEmpty ( ) ) {
            return String.format ( "Game %s not found", editGameDTO.getId ( ) );
        }
        Game game = gameRepository.findById ( editGameDTO.getId ( ) ).get ( );

        Map<String, String> properties = new HashMap<> ( );
        editGameDTO.getValues ( ).forEach ( v -> {
            String key = v.split ( "=" )[0];
            String value = v.split ( "=" )[1];

            properties.put ( key, value );
        } );

        properties.forEach ( ( k, v ) -> {
            switch (k) {
                case "title":
                    game.setTitle ( v );
                    break;
                case "description":
                    game.setDescription ( v );
                    break;
                case "price":
                    game.setPrice ( BigDecimal.valueOf ( Double.parseDouble ( v ) ) );
                    break;
                case "youTubeID":
                    game.setYouTubeID ( v );
                    break;
                case "ThumbnailUrl":
                    game.setThumbnailUrl ( v );
                    break;
                case "size":
                    game.setSize ( Double.parseDouble ( v ) );
                    break;
                case "releaseDate":
                    game.setReleaseDate ( LocalDate.parse ( v ) );
                    break;
            }
        } );

        gameRepository.save ( game );

        return String.format ( "Edited %s", game.getTitle ( ) );
    }

    @Transactional
    @Override
    public String deleteGame ( long id ) {
        if ( !userService.isCurrentUserAdmin ( ) ) {
            return "You are not allowed to delete game";
        }
        if ( gameRepository.findById ( id ).isEmpty ( ) ) {
            return String.format ( "Game with id: %d not exist", id );
        }
        String title = gameRepository.findById ( id ).get ( ).getTitle ( );

        gameRepository.deleteById ( id );

        return String.format ( "Deleted %s", title );
    }
}
