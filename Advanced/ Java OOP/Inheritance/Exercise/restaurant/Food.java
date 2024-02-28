package restaurant;

import java.math.BigDecimal;

class Food extends Product{
    private double grams;

    public Food ( String name, BigDecimal price, double grams ) {
        super ( name, price );
        this.setGrams ( grams );
    }
    private void setGrams ( double grams ) {
        this.grams = grams;
    }
    public double getGrams () {
        return grams;
    }
}
