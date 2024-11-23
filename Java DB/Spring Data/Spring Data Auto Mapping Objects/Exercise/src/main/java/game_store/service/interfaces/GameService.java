package game_store.service.interfaces;

import game_store.data.entities.DTOs.CreateGameDTO;
import game_store.data.entities.DTOs.EditGameDTO;
import game_store.data.entities.DTOs.GameFullInfo;
import game_store.data.entities.DTOs.ShortGameInfoDTO;

import java.util.Set;


public interface GameService {
    Set<ShortGameInfoDTO> getAllGames();

    GameFullInfo getGameDetails(String gameTitle);

    String addGame( CreateGameDTO createGameDTO);

    String editGame( EditGameDTO editGameDTO);

    String deleteGame(long id);
}
