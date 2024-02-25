package PizzaCalories;

import java.util.Map;

class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough ( String flourType, String bakingTechnique, double weight ) {
        this.setFlourType ( flourType );
        this.setBakingTechnique ( bakingTechnique );
        this.setWeight ( weight );
    }

    private void setFlourType ( String flourType ) {
        switch (flourType) {
            case "White":
            case "Wholegrain":
                this.flourType = flourType;
                break;

            default:
                throw new IllegalArgumentException ( "Invalid type of dough." );
        }

    }

    private void setBakingTechnique ( String bakingTechnique ) {
        switch (bakingTechnique) {
            case "Crispy":
            case "Chewy":
            case "Homemade":
                this.bakingTechnique = bakingTechnique;
                break;

            default:
                throw new IllegalArgumentException ( "Invalid type of dough." );
        }
    }

    private void setWeight ( double weight ) {
        if (weight < 1 || weight >200){
            throw new IllegalArgumentException ( "Dough weight should be in the range [1..200]." );

        }
        this.weight = weight;
    }

    public double calculateCalories () {
        Map<String,Double> doughModifiers = Map.of (
                "White", 1.5,
                "Wholegrain", 1.0,
                "Crispy", 0.9,
                "Chewy", 1.1,
                "Homemade", 1.0);

        return (2 * this.weight) * doughModifiers.get ( this.flourType ) * doughModifiers.get ( this.bakingTechnique );

    }
}
