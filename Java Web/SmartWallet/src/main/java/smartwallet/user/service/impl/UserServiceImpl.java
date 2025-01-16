package smartwallet.user.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import smartwallet.subscription.service.SubscriptionService;
import smartwallet.user.model.Country;
import smartwallet.user.model.User;
import smartwallet.user.property.UserProperty;
import smartwallet.user.repository.UserRepository;
import smartwallet.user.service.UserService;
import smartwallet.wallet.service.WalletService;
import smartwallet.web.dto.RegisterRequest;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final WalletService walletService;
    private final SubscriptionService subscriptionService;
    private final PasswordEncoder passwordEncoder;
    private final UserProperty userProperty;


    @Override
    public void register ( RegisterRequest registerRequest ) {
        User user = userRepository.save ( generateUser ( registerRequest ) );

        subscriptionService.createDefaultSubscription ( user );
        walletService.createNewWallet ( user );
    }

    @Override
    public boolean isUsernameOccupied ( String username ) {
        return userRepository.findByUsername (username).isPresent ();
    }

    private User generateUser ( RegisterRequest registerRequest ) {
        return User.builder ( )
                .username ( registerRequest.Username ( ) )
                .password ( passwordEncoder.encode ( registerRequest.Password ( ) ) )
                .role ( userProperty.role ())
                .isActive ( userProperty.accountState () )
                .country ( Country.valueOf ( registerRequest.Country ( ) ) )
                .createdOn ( userProperty.now () )
                .updatedOn ( userProperty.now () )
                .build ( );

    }
}
