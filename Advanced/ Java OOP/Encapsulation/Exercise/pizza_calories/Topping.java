package pizza_calories;

import java.util.Map;

class Topping {
    private String toppingType;
    private double weight;

    public Topping ( String toppingType, double weight ) {
        this.setToppingType ( toppingType );
        this.setWeight ( weight );
    }

    private void setToppingType ( String toppingType ) {
        switch (toppingType) {
            case "Meat":
            case "Veggies":
            case "Cheese":
            case "Sauce":
                this.toppingType = toppingType;
                break;
            default:
                throw new IllegalArgumentException ( String.format ( "Cannot place %s on top of your pizza.",toppingType ) );
        }
    }

    private void setWeight ( double weight ) {
        if (weight < 1 || weight > 50){
            throw new IllegalArgumentException ( String.format ( "%s weight should be in the range [1..50].",this.toppingType ));
        }
        this.weight = weight;
    }

    public double calculateCalories () {
        Map<String,Double> toppingModifiers = Map.of (
                "Meat", 1.2,
                "Veggies", 0.8,
                "Cheese", 1.1,
                "Sauce", 0.9);

        return (2 * weight) * toppingModifiers.get ( this.toppingType );
    }
}
