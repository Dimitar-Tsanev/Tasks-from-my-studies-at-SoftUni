package game_store.service.interfaces;

import game_store.data.entities.DTOs.CreateUserDTO;

import java.util.Set;

public interface UserService {

    String registerUser( CreateUserDTO createUserDTO );

    String loginUser( String username, String password );

    String logoutUser();

    boolean isCurrentUserAdmin();

    Set<String> getOwnedGames ();

    String getUserEmail ();

    boolean isUserLoggedIn();

    void save();

    boolean isUserHaveGame(String itemName);

}
