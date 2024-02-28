package restaurant;

import java.math.BigDecimal;

class Beverage extends Product{
    private double milliliters;
    public Beverage ( String name, BigDecimal price, double milliliters ) {
        super ( name, price );
        setMilliliters ( milliliters );
    }
    private void setMilliliters ( double milliliters ) {
        this.milliliters = milliliters;
    }
    public double getMilliliters () {
        return milliliters;
    }
}
