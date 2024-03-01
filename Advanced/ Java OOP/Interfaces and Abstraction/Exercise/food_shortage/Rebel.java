package food_shortage;

class Rebel implements Person, Buyer{
    private String name;
    private int age;
    private String group;
    private int food;

    public Rebel ( String name, int age, String group ) {
        this.setName ( name );
        this.setAge ( age );
        this.setGroup ( group );
    }

    private void setName ( String name ) {
        this.name = name;
    }

    private void setAge ( int age ) {
        this.age = age;
    }

    private void setGroup ( String group ) {
        this.group = group;
    }

    @Override
    public String getName () {
        return name;
    }

    @Override
    public int getAge () {
        return age;
    }

    public String getGroup () {
        return group;
    }

    @Override
    public int getFood () {
        return food;
    }

    @Override
    public void buyFood () {
        this.food += 5;
    }
}
