package wild_farm;

abstract class Felime extends Mammal {
    public Felime ( String animalName, String animalType, Double animalWeight, String livingRegion ) {
        super ( animalName, animalType, animalWeight, livingRegion );
    }

    @Override
    public abstract void eat ( Food food );

    @Override
    public abstract void makeSound ();
}
