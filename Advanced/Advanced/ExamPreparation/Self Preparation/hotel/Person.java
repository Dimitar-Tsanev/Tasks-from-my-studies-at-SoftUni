package hotel;

class Person {
    private String name;
    private int id;
    private int age;
    private String hometown = "n/a" ;

    public Person ( String name, int id, int age, String hometown ) {
        this.setName ( name );
        this.setId ( id );
        this.setAge ( age );
        this.setHometown ( hometown );
    }

    public String getName () {
        return name;
    }

    public int getId () {
        return id;
    }

    public int getAge () {
        return age;
    }

    public String getHometown () {
        return hometown;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public void setId ( int id ) {
        this.id = id;
    }

    public void setAge ( int age ) {
        this.age = age;
    }

    public void setHometown ( String hometown ) {
        this.hometown = hometown;
    }

    @Override
    public String toString () {
        return String.format ( "Person %s: %d, Age: %d, Hometown: %s",
                this.name,
                this.id,
                this.age,
                this.hometown );
    }
}
