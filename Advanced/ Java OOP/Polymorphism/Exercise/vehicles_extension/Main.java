package vehicles_extension;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        Map<String, Vehicle> vehicles = new LinkedHashMap<> (  );

        addVehicles ( vehicles,scanner );

        int commandNumber = Integer.parseInt ( scanner.nextLine ( ) );

        for ( int i = 1 ; i <= commandNumber ; i++ ) {
            String[] commandData = scanner.nextLine ( ).split ( "\\s+" );

            try {

                if ( "Drive".equals ( commandData[0] ) ) {
                    vehicles.get ( commandData[1] )
                            .drive ( Double.parseDouble ( commandData[2] ) );

                } else if ( "Refuel".equals ( commandData[0] ) ) {
                    vehicles.get ( commandData[1] )
                            .refuel ( Double.parseDouble ( commandData[2] ) );

                } else if ( "DriveEmpty".equals ( commandData[0] ) ) {
                    Bus bus = (Bus) vehicles.get ( "Bus" );
                    bus.driveEmpty ( Double.parseDouble ( commandData[2] ));
                }

            }catch (IllegalArgumentException exception){
                System.out.println ( exception.getMessage () );
            }
        }
        vehicles.values ().forEach ( System.out::println );
    }

    private static void addVehicles ( Map<String, Vehicle> vehicles, Scanner scanner ) {
        for ( int i = 0 ; i < 3 ; i++ ) {
            String[] vehicleData = scanner.nextLine ().split ( "\\s+" );

            Vehicle vehicle;
            switch (vehicleData[0]){
                case "Car":
                    vehicle = new Car (
                            Double.parseDouble ( vehicleData[1] ),
                            Double.parseDouble ( vehicleData[2] ),
                            Double.parseDouble ( vehicleData[3] ) );
                    break;
                case"Truck":
                    vehicle = new Truck (
                            Double.parseDouble ( vehicleData[1] ),
                            Double.parseDouble ( vehicleData[2] ),
                            Double.parseDouble ( vehicleData[3] ) );
                    break;
                case "Bus":
                    vehicle = new Bus (
                            Double.parseDouble ( vehicleData[1] ),
                            Double.parseDouble ( vehicleData[2] ),
                            Double.parseDouble ( vehicleData[3] ) );
                    break;
                default:
                    vehicle = null;
            }
            if(vehicle != null) {
                vehicles.put ( vehicleData[0], vehicle );
                
            }
        }
    }
}
