package RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;

public class Main {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        List<Car> cars = new ArrayList<> ( );

        int numberOfCars = Integer.parseInt ( scanner.nextLine ( ) );

        for ( int i = 0 ; i < numberOfCars ; i++ ) {
            String[] carInfo = scanner.nextLine ( ).split ( "\\s+" );

            Car car = createCar ( carInfo );
            cars.add ( car );
        }

        String filter = scanner.nextLine ( );

        BiPredicate<String, Car> getFilter = ( s, c ) -> {
            if ( "fragile".equals ( s ) ) {
                if ( c.getCargo ( ).getType ( ).equals ( s ) ) {
                    for ( Tier tier : c.getTires ( ) ) {
                        if ( tier.getPressure ( ) < 1 ) {
                            return true;
                        }
                    }
                }
            } else {
                if ( c.getCargo ( ).getType ( ).equals ( "flamable" ) ) {
                    return c.getEngine ( ).getEnginePower ( ) > 250;
                }
            }
            return false;
        };
        cars.stream ( ).filter ( c -> getFilter.test ( filter, c ) ).forEach ( c -> System.out.println ( c.getModel ( ) ) );
    }

    private static Car createCar ( String[] carInfo ) {
        String model = carInfo[0];

        int engineSpeed = Integer.parseInt ( carInfo[1] );
        int enginePower = Integer.parseInt ( carInfo[2] );

        int cargoWeight = Integer.parseInt ( carInfo[3] );
        String cargoType = carInfo[4];

        Engine engine = new Engine ( engineSpeed, enginePower );

        Cargo cargo = new Cargo ( cargoWeight, cargoType );

        Tier[] tires = createTiers ( carInfo );

        return new Car ( model, tires, engine, cargo );

    }

    private static Tier[] createTiers ( String[] carInfo ) {
        Tier[] tiers = new Tier[4];
        int counter = 0;
        for ( int i = 5 ; i < carInfo.length - 1 ; i += 2 ) {
            double tirePressure = Double.parseDouble ( carInfo[i] );
            int tierAge = Integer.parseInt ( carInfo[i + 1] );

            Tier tier = new Tier ( tirePressure, tierAge );
            tiers[counter] = tier;
            counter++;
        }
        return tiers;
    }
}
