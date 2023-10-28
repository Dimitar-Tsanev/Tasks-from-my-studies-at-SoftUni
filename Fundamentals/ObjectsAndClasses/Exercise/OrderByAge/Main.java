package OrderByAge;

import java.util.*;

public class Main {
    public static void main ( String[] args ) {
        Scanner scan =new Scanner ( System.in );

        String input = scan.nextLine ( );

        List <Person> persons = new ArrayList<> ();

        while (!input.equals ( "End" )){
            String [] personalInformation = input.split ( " " );
            String name = personalInformation [0];
            String identificationNumber = personalInformation [1];
            int age = Integer.parseInt ( personalInformation [2] );

            Person person = new Person ( name,identificationNumber,age );

            persons.add ( person );

            input = scan.nextLine ( );
        }
        persons.sort ( Comparator.comparing ( Person::getAge ) );
        for ( Person person: persons ) {
            System.out.print ( person.toString () );
        }
    }
}
