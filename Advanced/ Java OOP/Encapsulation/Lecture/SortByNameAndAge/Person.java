package SortByNameAndAge;

class Person {
    private static final String TEMPLATE = "%s %s is %d years old.";
    private String firstName;
    private String lastName;
    private int age;

    public Person ( String firstName, String lastName, int age ) {
        this.setFirstName ( firstName );
        this.setLastName ( lastName );
        this.setAge ( age );
    }
    private void setAge ( int age ) {
        this.age = age;
    }
    private void setFirstName ( String firstName ) {
        this.firstName = firstName;
    }
    private void setLastName ( String lastName ) {
        this.lastName = lastName;
    }
    public String getFirstName () {
        return this.firstName;
    }
    public String getLastName () {
        return lastName;
    }
    public int getAge () {
        return this.age;
    }
    @Override
    public String toString () {
        return String.format ( TEMPLATE,getFirstName (),getLastName (),getAge () );
    }
}
