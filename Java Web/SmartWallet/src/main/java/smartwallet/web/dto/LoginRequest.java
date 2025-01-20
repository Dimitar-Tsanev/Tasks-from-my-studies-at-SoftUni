package smartwallet.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginRequest(

        @NotBlank(message = "{request.username.length}")
        @Size(min = 6, message = "{request.username.length}")
        String username,

        @NotBlank(message = "{request.username.length}")
        @Size(min = 6, message = "{request.password.length}")
        String password) {
}
