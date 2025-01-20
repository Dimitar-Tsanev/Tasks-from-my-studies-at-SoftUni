package smartwallet.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import smartwallet.shared.utils.validation.anotations.UniqueUsername;

public record RegisterRequest(

        @Size(min = 6, message = "{request.username.length}")
        @NotBlank(message = "{request.username.length}")
        @UniqueUsername
        String username,

        @Size(min = 6, message = "{request.password.length}")
        @NotBlank(message = "{request.username.length}")
        String password,

        @NotBlank
        String country
) {
}
