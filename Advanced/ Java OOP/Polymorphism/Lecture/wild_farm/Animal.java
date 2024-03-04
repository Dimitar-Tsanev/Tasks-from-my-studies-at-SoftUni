package wild_farm;

abstract class Animal {
    private String animalName;
    private String animalType;
    private Double animalWeight;
    private Integer foodEaten;

    public Animal ( String animalName, String animalType, Double animalWeight ) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.foodEaten = 0;
    }

    public void setFoodEaten ( Integer foodEaten ) {
        this.foodEaten = foodEaten;
    }

    public String getAnimalName () {
        return animalName;
    }

    public String getAnimalType () {
        return animalType;
    }

    public Double getAnimalWeight () {
        return animalWeight;
    }

    public Integer getFoodEaten () {
        return foodEaten;
    }
    public abstract void makeSound ();

    public abstract void eat ( Food food );

}