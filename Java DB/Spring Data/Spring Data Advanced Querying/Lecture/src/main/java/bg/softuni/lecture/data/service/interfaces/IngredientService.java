package bg.softuni.lecture.data.service.interfaces;

import bg.softuni.lecture.data.entities.Ingredient;
import bg.softuni.lecture.data.entities.Shampoo;

import java.util.Collection;
import java.util.List;

public interface IngredientService {
    List<Ingredient> getByStartLetter(char letter);

    List<Ingredient> getIngredientsByNameOrderedByPrice( Collection<String> ingredientNames );

    List<Shampoo> getShampooWithIngredients(Collection<String> ingredientsNames);

    void deleteIngredient (String ingredientName);

    void increasePriceWithTenPercents();

    void updatePriceOfIngredientsWithNames(Collection<String> ingredients);
}
