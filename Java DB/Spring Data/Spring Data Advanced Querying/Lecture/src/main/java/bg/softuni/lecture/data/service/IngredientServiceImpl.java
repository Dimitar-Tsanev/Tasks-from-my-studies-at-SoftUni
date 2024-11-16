package bg.softuni.lecture.data.service;

import bg.softuni.lecture.data.entities.Ingredient;
import bg.softuni.lecture.data.entities.Shampoo;
import bg.softuni.lecture.data.repositories.IngredientRepository;
import bg.softuni.lecture.data.service.interfaces.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

@Service
public class IngredientServiceImpl  implements IngredientService {
    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<Ingredient> getByStartLetter ( char letter ) {
        return ingredientRepository.findAllByNameStartingWith (String.valueOf ( letter)  );
    }

    @Override
    public List<Ingredient> getIngredientsByNameOrderedByPrice ( Collection<String> ingredientNames ) {
        return ingredientRepository.findAllByNameInOrderByPrice ( ingredientNames );
    }

    @Override
    public List<Shampoo> getShampooWithIngredients ( Collection<String> ingredientsNames ) {
        List<Ingredient> ingredients = ingredientRepository.findAllByNameIn ( ingredientsNames );
        return ingredientRepository.findByIngredientsIn ( ingredients );
    }

    @Override
    public void deleteIngredient ( String ingredientName ) {
        ingredientRepository.deleteIngredientByName ( ingredientName );
    }

    @Override
    public void increasePriceWithTenPercents () {
        ingredientRepository.updatePrice ( BigDecimal.valueOf ( 1.10 ) );
    }

    @Override
    public void updatePriceOfIngredientsWithNames ( Collection<String> ingredients ) {
        ingredientRepository.updatePriceByName ( BigDecimal.valueOf ( 1.10 ), ingredients );
    }
}
