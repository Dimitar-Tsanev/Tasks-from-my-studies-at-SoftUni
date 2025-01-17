package smartwallet.web.dto;

import jakarta.validation.constraints.Size;

public record LoginRequest (
    @Size(min = 6, message = "{request.username.length}")
    String username,

    @Size(min = 6, message = "{request.password.length}")
    String password){
}
