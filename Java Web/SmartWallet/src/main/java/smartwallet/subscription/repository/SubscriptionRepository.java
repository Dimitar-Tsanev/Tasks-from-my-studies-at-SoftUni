package smartwallet.subscription.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import smartwallet.subscription.model.Subscription;

import java.util.UUID;

@Service
public interface SubscriptionRepository extends JpaRepository<Subscription, UUID> {
}
