package products_shop.data.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import products_shop.data.entity.Product;

import java.util.Set;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Set<Product> findAllByPriceIsBetweenAndBuyerIsNullOrderByPriceAsc ( Double min, Double max );

}
