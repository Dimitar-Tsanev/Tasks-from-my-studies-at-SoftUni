package border_control;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        String input = scanner.nextLine ( );

        List<Identifiable> passengers = new ArrayList<> ();

        while (!"End".equals ( input )){
            addPassenger ( input, passengers );

            input = scanner.nextLine ( );
        }
        String fakesNumbers = scanner.nextLine ();

        passengers.stream ()
                .filter ( p-> p.getId ().endsWith ( fakesNumbers ) )
                .forEach ( p -> System.out.println ( p.getId () ) );

    }
    private static void addPassenger (String input, List<Identifiable> passengers ){
        String[] identificationData = input.split ( "\\s+" );

        if ( identificationData.length == 2 ){
            Robot robot = new Robot ( identificationData[0],identificationData[1] );

            passengers.add ( robot );

        }else if ( identificationData.length == 3 ){
            Citizen citizen = new Citizen ( identificationData[0],
                    Integer.parseInt (  identificationData[1] ),
                    identificationData[2]);

            passengers.add ( citizen );

        }
    }
}
