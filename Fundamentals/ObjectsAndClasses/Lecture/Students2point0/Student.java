package Students2point0;

public class Student {
    private String firstName;
    private String lastName;
    private int age;
    private String town;
    public Student (String firstName, String lastName, int age, String town){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.town = town;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public int getAge() {
        return age;
    }
    public String getTown(){
        return town;
    }

    public void setAge ( int age ) {
        this.age = age;
    }

    public void setTown ( String town ) {
        this.town = town;
    }
    public String studentInformation (){
        return String.format ( "%s %s is %d years old",firstName,lastName,age );
    }
}
