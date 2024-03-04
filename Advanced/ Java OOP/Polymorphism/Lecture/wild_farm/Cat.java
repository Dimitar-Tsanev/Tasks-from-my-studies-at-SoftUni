package wild_farm;

import java.text.DecimalFormat;

class Cat extends Felime {
    private String breed;

    public Cat ( String animalName, String animalType, Double animalWeight, String livingRegion, String breed ) {
        super ( animalName, animalType, animalWeight, livingRegion );
        this.breed = breed;
    }

    public String getBreed () {
        return this.breed;
    }

    public void eat ( Food food ) {
        super.setFoodEaten ( getFoodEaten ( ) + food.getQuantity ( ) );
    }

    @Override
    public void makeSound () {
        System.out.println ( "Meowwww" );
    }

    @Override
    public String toString () {
        return String.format ( "%s[%s, %s, %s, %s, %d]",
                this.getAnimalType ( ),
                this.getAnimalName ( ),
                this.getBreed ( ),
                new DecimalFormat ( "#.##" ).format ( this.getAnimalWeight ( ) ),
                this.getLivingRegion ( ),
                this.getFoodEaten ( ) );
    }
}
