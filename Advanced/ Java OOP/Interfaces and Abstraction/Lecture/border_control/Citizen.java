package border_control;

class Citizen implements Identifiable {
    private String name;
    private int age;
    private String id;

    public Citizen ( String name, int age, String id ) {
        this.setName ( name );
        this.setAge ( age );
        this.setId ( id );
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public void setAge ( int age ) {
        this.age = age;
    }

    public void setId ( String id ) {
        this.id = id;
    }

    public String getName () {
        return this.name;
    }

    public int getAge () {
        return this.age;
    }

    @Override
    public String getId () {
        return this.id;
    }
}
