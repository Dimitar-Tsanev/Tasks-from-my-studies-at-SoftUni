package OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        int linesNumber = Integer.parseInt ( scanner.nextLine ());

        List<Person> persons = new ArrayList<> ();

        for ( int i = 0 ; i < linesNumber ; i++ ) {
            String[] personalData = scanner.nextLine ().split ( "\\s+" );
            String name = personalData[0];
            int age = Integer.parseInt ( personalData[1] );

            Person person = new Person ( name,age );

            persons.add ( person );

        }
        Comparator<Person> nameCompare = Comparator.comparing ( Person::getName );

        persons.stream ()
                .filter ( person -> person.getAge () > 30 ).sorted (nameCompare)
                .forEach ( System.out::println );
    }
}
