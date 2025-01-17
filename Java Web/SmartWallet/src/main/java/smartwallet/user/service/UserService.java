package smartwallet.user.service;

import smartwallet.user.model.User;
import smartwallet.web.dto.LoginRequest;
import smartwallet.web.dto.RegisterRequest;

public interface UserService {
    void register( RegisterRequest registerRequest);

    User login( LoginRequest loginRequest);

    boolean isUsernameOccupied ( String username );
}
