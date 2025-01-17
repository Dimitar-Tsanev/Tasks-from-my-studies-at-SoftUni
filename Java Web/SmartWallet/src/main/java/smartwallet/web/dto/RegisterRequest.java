package smartwallet.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import smartwallet.shared.utils.validation.anotations.UniqueUsername;

public record RegisterRequest(

        @Size(min = 6, message = "{request.username.length}")
        @UniqueUsername
        String Username,

        @Size(min = 6, message = "{request.password.length}")
        String Password,

        @NotBlank
        String Country
) {
}
