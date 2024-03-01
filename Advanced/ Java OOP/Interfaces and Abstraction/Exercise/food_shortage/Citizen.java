package food_shortage;

class Citizen implements Person, Identifiable, Buyer{
    private String name;
    private int age;
    private String id;
    private String birthDate;
    private int food;

    public Citizen ( String name, int age, String id, String birthDate ) {
        this.setName ( name );
        this.setAge ( age );
        this.setId ( id );
        this.setBirthDate ( birthDate );
    }

    private void setName ( String name ) {
        this.name = name;
    }

    private void setAge ( int age ) {
        this.age = age;
    }

    private void setId ( String id ) {
        this.id = id;
    }

    private void setBirthDate ( String birthDate ) {
        this.birthDate = birthDate;
    }

    @Override
    public void buyFood () {
        this.food += 10;
    }

    @Override
    public String getName () {
        return name;
    }

    @Override
    public int getAge () {
        return age;
    }

    @Override
    public String getId () {
        return id;
    }

    @Override
    public int getFood () {
        return food;
    }
}
