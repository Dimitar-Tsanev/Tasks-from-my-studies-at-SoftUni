package products_shop.data.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import products_shop.data.entity.User;

import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Set<User> findAllBySoldProductsNotNullOrderByLastNameAscFirstNameAsc();
}
