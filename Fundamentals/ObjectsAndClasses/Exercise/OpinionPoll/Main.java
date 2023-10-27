package OpinionPoll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main ( String[] args ) {

        Scanner scan = new Scanner ( System.in );

        int personsCount = Integer.parseInt ( scan.nextLine ( ) );

        List<Person> persons = new ArrayList<> ();

        for ( int i = 0 ; i < personsCount ; i++ ) {
            String [] personInformation = scan.nextLine ().split ( " " );
            Person person = new Person ( personInformation[0],Integer.parseInt ( personInformation [1] ) );
            persons.add ( person );
        }
        for ( Person person:persons ) {
            if (person.getYears () > 30){
                System.out.println ( person.getInformation () );
            }
        }
    }
}
