package wild_farm;

import java.text.DecimalFormat;

abstract class Mammal extends Animal {
    private String livingRegion;

    public Mammal ( String animalName, String animalType, Double animalWeight, String livingRegion ) {
        super ( animalName, animalType, animalWeight );
        this.livingRegion = livingRegion;
    }

    public String getLivingRegion () {
        return livingRegion;
    }

    @Override
    public abstract void eat ( Food food );

    @Override
    public abstract void makeSound ();

    @Override
    public String toString () {
        return String.format ( "%s[%s, %s, %s, %d]",
                this.getAnimalType ( ),
                this.getAnimalName ( ),
                new DecimalFormat ( "#.##" ).format ( this.getAnimalWeight ( ) ),
                this.getLivingRegion ( ),
                this.getFoodEaten ( ) );

    }
}
