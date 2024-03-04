package wild_farm;

public class Zebra extends Mammal{
    public Zebra (  String animalName,String animalType,  Double animalWeight, String livingRegion ) {
        super ( animalName, animalType,animalWeight, livingRegion );
    }
    public void eat (Food food){
        if (!food.getClass ().getSimpleName ().equals ( "Vegetable" )){
            System.out.println ( "Zebras are not eating that type of food!" );

        }else {
            super.setFoodEaten ( getFoodEaten ( ) + food.getQuantity ( ) );

        }
    }
    @Override
    public void makeSound () {
        System.out.println ( "Zs" );
    }
}
