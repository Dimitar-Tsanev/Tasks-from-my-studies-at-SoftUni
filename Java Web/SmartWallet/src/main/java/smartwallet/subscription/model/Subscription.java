package smartwallet.subscription.model;

import jakarta.persistence.*;
import lombok.*;
import smartwallet.user.model.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    private User owner;

    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    private SubscriptionStatus status;

    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    private SubscriptionPeriod period;

    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    private SubscriptionType type;

    @Basic(optional = false)
    private BigDecimal price;

    @Basic(optional = false)
    private boolean renewalAllowed;

    @Basic(optional = false)
    private LocalDateTime createdOn;

    @Basic(optional = false)
    private LocalDateTime completedOn;

}
