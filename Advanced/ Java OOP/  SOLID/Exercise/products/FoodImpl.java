package products;

public abstract class FoodImpl extends ProductImpl implements Food{

    protected FoodImpl ( double grams, double caloriesPer100Grams ) {
        super ( grams, caloriesPer100Grams );
    }

}
