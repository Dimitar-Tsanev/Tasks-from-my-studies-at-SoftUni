package bg.softuni.lecture.data.repositories;

import bg.softuni.lecture.data.entities.Label;
import bg.softuni.lecture.data.entities.Shampoo;
import bg.softuni.lecture.data.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {
    List<Shampoo> findAllBySizeOrderById ( Size size);

    List<Shampoo> findAllBySizeOrLabelOrderByPriceAsc( Size size, Label label );

    List<Shampoo> findAllByPriceGreaterThanOrderByPriceDesc( BigDecimal price );

    Integer countAllByPriceLessThan(BigDecimal price);

    @Query(value ="select s from Shampoo s where size(s.ingredients) < :count")
    List<Shampoo> findAllByIngredientsCount(int count);
}
