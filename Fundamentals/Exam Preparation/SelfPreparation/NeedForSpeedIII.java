import java.util.LinkedHashMap;
import java.util.Scanner;

public class NeedForSpeedIII {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        int numberOfCars = Integer.parseInt ( scanner.nextLine () );

        LinkedHashMap <String, Integer> carsFuel = new LinkedHashMap<> ();
        LinkedHashMap <String, Integer> carsMileage = new LinkedHashMap<> ();

        int maxFuel = 75;

        for ( int i = 1 ; i <= numberOfCars  ; i++ ) {
            String[] carData = scanner.nextLine ().split ( "\\|" );
            String car = carData[0];
            int mileage = Integer.parseInt ( carData[1] );
            int fuel = Integer.parseInt ( carData[2] );

            if (fuel > maxFuel){
                fuel = maxFuel;
            }

            carsFuel.put ( car,fuel );
            carsMileage.put ( car, mileage );

        }
        String commandLine = scanner.nextLine ( );

        while (!commandLine.equals ( "Stop" )){
            String[] commandData = commandLine.split ( " : " );
            String command = commandData[0];
            String car = commandData[1];

            switch (command){
                case "Drive":
                    int distance = Integer.parseInt ( commandData[2] );
                    int neededFuel = Integer.parseInt ( commandData[3] );

                    if(carsFuel.get ( car ) < neededFuel){
                        System.out.println ( "Not enough fuel to make that ride" );

                    }else {
                        carsMileage.put ( car, carsMileage.get ( car ) + distance );
                        carsFuel.put ( car, carsFuel.get ( car ) - neededFuel );

                        System.out.printf ( "%s driven for %d kilometers. %d liters of fuel consumed.%n", car,distance,neededFuel);

                        if (carsMileage.get ( car ) >= 100_000 ){
                            carsMileage.remove ( car );
                            carsFuel.remove ( car );

                            System.out.println ( "Time to sell the " + car + "!");

                        }
                    }
                    break;

                case "Refuel":
                    int additionalFuel = Integer.parseInt ( commandData[2] );

                    if ( (carsFuel.get ( car ) + additionalFuel) > maxFuel){
                        additionalFuel = maxFuel - carsFuel.get ( car );

                    }
                    carsFuel.put ( car, carsFuel.get ( car ) + additionalFuel );

                    System.out.printf ( car + " refueled with %d liters%n", additionalFuel );

                    break;

                case "Revert":
                    int revertedMileage = Integer.parseInt ( commandData[2]);

                    if ( ( carsMileage.get ( car ) - revertedMileage ) < 10_000 ){
                        carsMileage.put ( car, 10_000 );

                    }else {
                        carsMileage.put ( car, carsMileage.get ( car ) - revertedMileage );

                        System.out.printf ( car + " mileage decreased by %d kilometers%n",revertedMileage );

                    }
                    break;

            }
            commandLine = scanner.nextLine ( );

        }
        carsMileage.forEach ( (k,v) -> System.out.printf ( "%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", k,v,carsFuel.get ( k ) ) );
    }
}
