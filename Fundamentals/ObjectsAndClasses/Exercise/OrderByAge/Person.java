package OrderByAge;

public class Person {
    private String name;
    private String identificationNumber;
    private int age;

    public Person ( String name, String identificationNumber, int age ) {
        this.name = name;
        this.identificationNumber = identificationNumber;
        this.age = age;
    }
    public int getAge(){
        return this.age;
    }
    @Override
    public String toString (){
        return String.format ( "%s with ID: %s is %d years old.%n",
                this.name, this.identificationNumber, this.age );
    }
}
