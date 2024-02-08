package ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        List<Person> peoples = new ArrayList<> ();

        String data = scanner.nextLine ( );

        while (!"END".equals ( data )){
            String[] personalData = data.split ( "\\s+" );

            String name = personalData[0];
            int age = Integer.parseInt ( personalData[1] );
            String town = personalData[2];

            Person person = new Person ( name,age,town );

            peoples.add ( person );

            data = scanner.nextLine ( );
        }

        int index = Integer.parseInt ( scanner.nextLine () );

        if (index >= peoples.size () || index < 0  ){
            System.out.println ("No matches" );
            return;
        }

        Person person = peoples.get ( index );

        List <Person> matches = peoples.stream ( )
                .filter ( people -> person.compareTo ( people ) == 0 )
                .collect( Collectors.toList());

        if(matches.isEmpty ()){
            System.out.println ("No matches" );
            return;
        }

        System.out.println ( matches.size () +
                " " +
                (peoples.size ( ) - matches.size ( )) +
                " " +
                peoples.size ( ));
    }
}
