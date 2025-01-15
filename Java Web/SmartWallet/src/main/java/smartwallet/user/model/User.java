package smartwallet.user.model;

import jakarta.persistence.*;
import lombok.*;
import smartwallet.subscription.model.Subscription;
import smartwallet.wallet.model.Wallet;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String username;

    private String firstName;

    private String lastName;

    private String profilePicture;

    @Column(unique = true)
    private String email;

    @Basic(optional = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Enumerated(EnumType.STRING)
    private Country country;

    @Basic(optional = false)
    private boolean isActive;

    @Basic(optional = false)
    private LocalDateTime createdOn;

    @Basic(optional = false)
    private LocalDateTime updatedOn;

    @OneToMany (mappedBy = "owner", fetch = FetchType.EAGER)
    private List<Wallet> wallets;

    @OneToMany (mappedBy = "owner", fetch = FetchType.EAGER)
    private List<Subscription> subscriptions;

}
