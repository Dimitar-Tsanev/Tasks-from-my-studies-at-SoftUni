package AnimalFarm;

class Chicken {
    private static final String TEMPLATE = "Chicken %s (age %d) can produce %f eggs per day.";
    private String name;
    private int age;

    public Chicken ( String name, int age ) {
        this.setName ( name );
        this.setAge ( age );
    }
    private void setName ( String name ) {
        if (name == null || name.isBlank () ){
            throw new IllegalArgumentException ( "Name cannot be empty." );

        }
        this.name = name;
    }
    private void setAge ( int age ) {
        if (age > 15 || age < 0){
            throw new IllegalArgumentException ( "Age should be between 0 and 15." );

        }
        this.age = age;
    }
    private double calculateProductPerDay(){
        return getAge () < 6 ? 2.0: getAge () < 12 ? 1.0 : 0.75;
    }

    private String getName () {
        return this.name;
    }
    private int getAge () {
        return this.age;
    }
    public double productPerDay (){
        return this.calculateProductPerDay ();

    }
    @Override
    public String toString () {
        return String.format ( TEMPLATE, getName (), getAge (), productPerDay() );
    }
}
