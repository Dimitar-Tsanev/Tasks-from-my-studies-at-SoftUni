package bg.softuni.lecture.data.repositories;

import bg.softuni.lecture.data.entities.Ingredient;
import bg.softuni.lecture.data.entities.Shampoo;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    List<Ingredient> findAllByNameStartingWith ( String letter);


    List<Ingredient> findAllByNameInOrderByPrice( Collection<String> names);

    List<Ingredient> findAllByNameIn(Collection<String> names);

    @Query(value = "select s from Shampoo s join s.ingredients i where i in :ingredients")
    List<Shampoo> findByIngredientsIn(@Param(value = "ingredients") Collection<Ingredient> ingredients);

    @Transactional
    void deleteIngredientByName( String name );

    @Transactional
    @Modifying
    @Query(value = "UPDATE Ingredient SET price = price * :amount")
    void updatePrice( BigDecimal amount  );

    @Transactional
    @Modifying
    @Query(value = "UPDATE Ingredient SET price = price * :amount WHERE name in :ingredientsNames" )
    void updatePriceByName( BigDecimal amount, Collection<String> ingredientsNames );
}
