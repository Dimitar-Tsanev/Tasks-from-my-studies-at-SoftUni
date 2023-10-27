package VehicleCatalogue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );

        List<Vehicle> vehicles = new ArrayList<> ( );

        String input = scan.nextLine ( );

        while (!input.equals ( "End" )) {
            String[] vehicleInformation = input.split ( " " );
            String type = vehicleInformation[0];
            String model = vehicleInformation[1];
            String color = vehicleInformation[2];
            int horsepower = Integer.parseInt ( vehicleInformation[3] );

            Vehicle vehicle = new Vehicle ( type, model, color, horsepower );

            vehicles.add ( vehicle );

            input = scan.nextLine ( );
        }
        String wantedModel = scan.nextLine ( );

        while (!wantedModel.equals ( "Close the Catalogue" )) {
            for ( Vehicle vehicle : vehicles ) {
                if ( vehicle.getModel ( ).equals ( wantedModel ) ) {
                    System.out.print ( vehicle.getInformation ( ) );
                    break;
                }
            }
            wantedModel = scan.nextLine ( );
        }
        System.out.printf ( "Cars have average horsepower of: %.2f.%n", calculateAverageCarsHorsepower ( vehicles ) );
        System.out.printf ( "Trucks have average horsepower of: %.2f.%n", calculateAverageTrucksHorsepower ( vehicles ) );
    }

    public static double calculateAverageTrucksHorsepower ( List<Vehicle> vehicles ) {
        int allTrucks = 0;
        int totalHorsepower = 0;
        for ( Vehicle vehicle : vehicles ) {
            if ( vehicle.getType ( ).equals ( "truck" ) ) {
                totalHorsepower += vehicle.getHorsepower ( );
                allTrucks++;
            }
        }
        if ( allTrucks > 0 ) {
            return totalHorsepower * 1.0 / allTrucks;
        } else {
            return 0.00;
        }
    }

    public static double calculateAverageCarsHorsepower ( List<Vehicle> vehicles ) {
        int allCars = 0;
        int totalHorsepower = 0;
        for ( Vehicle vehicle : vehicles ) {
            if ( vehicle.getType ( ).equals ( "car" ) ) {
                totalHorsepower += vehicle.getHorsepower ( );
                allCars++;
            }
        }
        if ( allCars > 0 ) {
            return totalHorsepower * 1.0 / allCars;
        } else {
            return 0.00;
        }

    }
}
