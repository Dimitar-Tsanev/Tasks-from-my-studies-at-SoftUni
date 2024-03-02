package animals_polymorphism_task3;

class Dog extends Animal{
    private static final String SOUND = "DJAAF";
    public Dog ( String name, String favouriteFood ) {
        super ( name, favouriteFood );
    }
    @Override
    public String explainSelf () {
        return String.format ( Animal.TEMPLATE + SOUND,this.getName (),this.getFavouriteFood () );
    }
}
