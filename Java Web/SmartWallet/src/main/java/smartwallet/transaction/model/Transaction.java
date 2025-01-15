package smartwallet.transaction.model;

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
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    private User owner;

    @Basic(optional = false)
    private String sender;

    @Basic(optional = false)
    private String receiver;

    @Basic(optional = false)
    private BigDecimal amount;

    @Basic(optional = false)
    private BigDecimal balanceLeft;

    @Basic(optional = false)
    private Currency currency;

    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    private String description;

    private String failureReason;

    @Basic(optional = false)
    private LocalDateTime createdOn;

}
