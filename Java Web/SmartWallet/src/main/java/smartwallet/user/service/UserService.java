package smartwallet.user.service;

import smartwallet.web.dto.RegisterRequest;

public interface UserService {
    void register( RegisterRequest registerRequest);

    boolean isUsernameOccupied ( String username );
}
