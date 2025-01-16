package smartwallet.user.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import smartwallet.user.model.UserRole;

import java.time.LocalDateTime;

@ConfigurationProperties(prefix = "users.default")
public record UserProperty(
        UserRole role,
        boolean accountState,
        LocalDateTime now
        ) {

    public UserProperty {
        now = LocalDateTime.now();
    }

}
