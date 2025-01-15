package smartwallet.wallet.model;

import jakarta.persistence.*;
import lombok.*;
import smartwallet.user.model.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    private User owner;

    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    private WalletStatus status;

    @Basic(optional = false)
    private BigDecimal balance;

    @Basic(optional = false)
    private Currency currency;

    @Basic(optional = false)
    private LocalDateTime createdOn;

    @Basic(optional = false)
    private LocalDateTime updatedOn;

}
