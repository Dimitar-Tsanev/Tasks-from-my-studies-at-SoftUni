package animals_polymorphism_task3;

abstract class Animal {
    protected static final String TEMPLATE = "I am %s and my favourite food is %s%n";
    private final String name;
    private final String favouriteFood;

    public Animal ( String name, String favouriteFood ) {
        this.name = name;
        this.favouriteFood = favouriteFood;
    }

    protected String getName () {
        return this.name;
    }

    public String getFavouriteFood () {
        return this.favouriteFood;
    }

    public abstract String explainSelf();

}
