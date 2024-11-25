package products_shop.data.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import products_shop.data.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
