package CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        int numberOfEngines = Integer.parseInt ( scanner.nextLine ( ) );

        List<Engine> engines = new ArrayList<> ( );

        for ( int i = 0 ; i < numberOfEngines ; i++ ) {
            String[] engineData = scanner.nextLine ( ).split ( "\\s+" );

            Engine engine = createEngine ( engineData );
            engines.add ( engine );
        }

        int carsNumber = Integer.parseInt ( scanner.nextLine ( ) );

        for ( int i = 0 ; i < carsNumber ; i++ ) {
            String[] carData = scanner.nextLine ( ).split ( "\\s+" );

            Car car = createCar ( carData, engines );

            System.out.println ( car );
        }

    }

    private static Car createCar ( String[] carData, List<Engine> engines ) {
        String model = carData[0];
        Engine engine = getEngine(carData[1], engines);
        int weight;
        String color;

        if ( carData.length == 3 ) {
            if ( Character.isDigit ( carData[2].charAt ( 0 ) ) ) {
                weight = Integer.parseInt ( carData[2] );
                return new Car ( model, engine, weight );

            } else {
                color = carData[2];
                return new Car ( model, engine, color );
            }

        } else if ( carData.length == 4 ) {
            weight = Integer.parseInt ( carData[2] );
            color = carData[3];
            return new Car ( model, engine, weight, color );

        }
        return new Car ( model, engine );
    }

    private static Engine getEngine ( String engineName, List<Engine> engines ) {
        for ( Engine engine: engines) {
            if ( engineName.equals ( engine.getModel () )){
                return engine;
            }
        }
        return new Engine ( );
    }

    private static Engine createEngine ( String[] engineData ) {
        String model = engineData[0];
        int power = Integer.parseInt ( engineData[1] );
        int displacements;
        String efficiency;

        if ( engineData.length == 3 ) {
            if ( Character.isDigit ( engineData[2].charAt ( 0 ) ) ) {
                displacements = Integer.parseInt ( engineData[2] );
                return new Engine ( model, power, displacements );

            } else {
                efficiency = engineData[2];
                return new Engine ( model, power, efficiency );
            }

        } else if ( engineData.length == 4 ) {
            displacements = Integer.parseInt ( engineData[2] );
            efficiency = engineData[3];
            return new Engine ( model, power, displacements, efficiency );

        }
        return new Engine ( model, power );
    }
}
