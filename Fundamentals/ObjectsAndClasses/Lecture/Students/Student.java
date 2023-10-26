package Students;

public class Student {
    private String firstname;
    private String lastname;
    private int age;
    private String town;

    public Student ( String firstname, String lastname, int age, String town ) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.town = town;
    }

    public String getFirstname () {
        return firstname;
    }

    public String getLastname () {
        return lastname;
    }

    public int getAge () {
        return age;
    }

    public String getTown () {
        return town;
    }

    public String formatInformation ( ) {
        firstname = getFirstname ( );
        lastname = getLastname ( );
        age = getAge ( );
        return String.format ( "%s %s is %d years old",firstname,lastname,age );
    }

}
