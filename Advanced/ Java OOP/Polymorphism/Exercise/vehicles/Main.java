package vehicles;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        Map<String, Vehicle> vehicles = new HashMap<> ( );

        addVehicles ( vehicles,scanner );

        int commandNumber = Integer.parseInt ( scanner.nextLine ( ) );

        for ( int i = 1 ; i <= commandNumber ; i++ ) {
            String[] commandData = scanner.nextLine ( ).split ( "\\s+" );

            if ( "Drive".equals ( commandData[0] ) ) {
              vehicles.get ( commandData[1] )
                      .drive ( Double.parseDouble ( commandData[2] ) );

            } else if ( "Refuel".equals ( commandData[0] ) ) {
                vehicles.get ( commandData[1] )
                        .refuel ( Double.parseDouble ( commandData[2] ) );
            }
        }
        vehicles.values ().forEach ( System.out::println );
    }

    private static void addVehicles ( Map<String, Vehicle> vehicles, Scanner scanner ) {
        String[] carData = scanner.nextLine ( ).split ( "\\s+" );
        String[] truckData = scanner.nextLine ( ).split ( "\\s+" );

        vehicles.put ( carData[0], new Car (
                Double.parseDouble ( carData[1] ),
                Double.parseDouble ( carData[2] ) ) );

        vehicles.put ( truckData[0], new Truck (
                Double.parseDouble ( truckData[1] ),
                Double.parseDouble ( truckData[2] ) ) );

    }
}
