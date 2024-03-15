package products;

public abstract class ProductImpl implements Product{
    private double grams;
    private double caloriesPer100Grams;

    protected ProductImpl ( double grams, double caloriesPer100Grams ) {
        this.setGrams ( grams );
        this.setCaloriesPer100Grams ( caloriesPer100Grams );
    }
    private void setGrams ( double grams ) {
        this.grams = grams;
    }
    private void setCaloriesPer100Grams ( double caloriesPer100Grams ) {
        this.caloriesPer100Grams =  caloriesPer100Grams;
    }
    @Override
    public double getCalories (){
        return this.caloriesPer100Grams / 100 * this.grams;
    }
    @Override
    public double amount () {
        return this.grams / 1000;
    }
}
