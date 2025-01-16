package smartwallet.subscription.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import smartwallet.subscription.model.Subscription;
import smartwallet.subscription.property.SubscriptionProperty;
import smartwallet.subscription.repository.SubscriptionRepository;
import smartwallet.subscription.service.SubscriptionService;
import smartwallet.user.model.User;


@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final SubscriptionProperty subscriptionProperty;

    @Override
    public void createDefaultSubscription ( User user ) {
        Subscription baseSubscription = Subscription.builder ( )
                .owner ( user )
                .status ( subscriptionProperty.status ( ) )
                .period ( subscriptionProperty.period ( ) )
                .type ( subscriptionProperty.type ( ) )
                .price ( subscriptionProperty.price ( ) )
                .renewalAllowed ( subscriptionProperty.renewalAllowed ( ) )
                .createdOn ( subscriptionProperty.createdOn ( ) )
                .completedOn ( subscriptionProperty.completedOn ( ) )
                .build ( );

        subscriptionRepository.save ( baseSubscription );
    }
}
