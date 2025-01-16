package smartwallet.wallet.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import smartwallet.wallet.model.WalletStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;

@ConfigurationProperties(prefix = "wallet.default")
public record WalletProperty(
        WalletStatus status,
        BigDecimal balance,
        Currency currency,
        LocalDateTime createdOn,
        LocalDateTime updatedOn
) {
    public WalletProperty {
        currency = Currency.getInstance(currency.getCurrencyCode());
        createdOn = LocalDateTime.now();
        updatedOn = createdOn;
    }
}
