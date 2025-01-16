package smartwallet.subscription.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import smartwallet.subscription.model.SubscriptionPeriod;
import smartwallet.subscription.model.SubscriptionStatus;
import smartwallet.subscription.model.SubscriptionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@ConfigurationProperties (prefix = "subscription.default")
public record SubscriptionProperty (
        SubscriptionStatus status,
        SubscriptionPeriod period,
        SubscriptionType type,
        BigDecimal price,
        boolean renewalAllowed,
        LocalDateTime createdOn,
        LocalDateTime completedOn
){
    public SubscriptionProperty{
        createdOn = LocalDateTime.now();
        completedOn = createdOn.plusMonths ( 1 );
    }
}
