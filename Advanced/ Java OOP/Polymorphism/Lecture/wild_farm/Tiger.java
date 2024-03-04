package wild_farm;

public class Tiger extends Felime {

    public Tiger (  String animalName, String animalType, Double animalWeight, String livingRegion ) {
        super ( animalName, animalType, animalWeight, livingRegion);
    }
    public void eat ( Food food){
        if (!"Meat".equals ( food.getClass ().getSimpleName () )){
            System.out.println ( "Tigers are not eating that type of food!" );

        }else {
            super.setFoodEaten ( getFoodEaten ( ) + food.getQuantity ( ) );

        }
    }
    @Override
    public void makeSound () {
        System.out.println ( "ROAAR!!!");
    }
}
