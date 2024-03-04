package wild_farm;

public class Mouse extends Mammal {
    public Mouse ( String animalName, String animalType, Double animalWeight, String livingRegion ) {
        super ( animalName, animalType, animalWeight, livingRegion );
    }
    @Override
    public void eat ( Food food ) {
        if ( !"Vegetable".equals ( food.getClass ( ).getSimpleName ( ) ) ) {
            System.out.println ( "Mice are not eating that type of food!" );
        } else {
            super.setFoodEaten ( getFoodEaten ( ) + food.getQuantity ( ) );
        }
    }

    @Override
    public void makeSound () {
        System.out.println ( "SQUEEEAAAK!" );
    }
}
