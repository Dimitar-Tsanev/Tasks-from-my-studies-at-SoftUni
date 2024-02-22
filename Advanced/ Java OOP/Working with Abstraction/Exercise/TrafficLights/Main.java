package TrafficLights;

import java.util.Scanner;

public class Main {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        String[] strings = scanner.nextLine ().split ( "\\s+" );

        TrafficLight trafficLight = new TrafficLight ( strings );

        int changesNumber = Integer.parseInt ( scanner.nextLine ());

        for ( int i = 1 ; i <= changesNumber  ; i++ ) {
            System.out.println ( trafficLight.getNextLights ()
                    .toString ()
                    .replaceAll ( "[\\[,\\]]","" ) );
        }
    }
}
