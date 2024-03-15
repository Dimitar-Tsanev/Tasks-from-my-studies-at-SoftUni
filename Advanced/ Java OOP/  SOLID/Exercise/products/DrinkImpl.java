package products;

public abstract class DrinkImpl extends ProductImpl implements Drink {
    private double milliliters;
    protected DrinkImpl ( double milliliters, double density, double caloriesPer100Grams ) {
        super ( milliliters * density, caloriesPer100Grams );
        this.setMilliliters ( milliliters );
    }
    private void setMilliliters ( double milliliters ) {
        this.milliliters = milliliters;
    }
    @Override
    public double amount () {
        return this.milliliters / 1000;
    }
}
