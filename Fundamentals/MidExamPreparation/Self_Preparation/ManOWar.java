import java.util.Arrays;
import java.util.Scanner;

public class ManOWar {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );

        int [] pirateShips = Arrays.stream ( scan.nextLine ().split ( ">" ) )
                .mapToInt ( Integer::parseInt )
                .toArray ();

        int [] warShips = Arrays.stream ( scan.nextLine ().split ( ">" ) )
                .mapToInt ( Integer::parseInt )
                .toArray ();

        int maximumHealth = Integer.parseInt ( scan.nextLine () );

        String [] commandline = scan.nextLine ().split ( " " );

        while (!commandline [0].equals ( "Retire" )){
            switch (commandline[0]){
                case "Fire":
                    int shipAtIndex = Integer.parseInt ( commandline[1] );
                    if ( shipAtIndex >= 0 && shipAtIndex < warShips.length){
                        warShips [shipAtIndex] -= Integer.parseInt ( commandline [2]);
                        if (warShips[shipAtIndex] <= 0){
                            System.out.println ( "You won! The enemy ship has sunken." );
                            return;
                        }
                    }
                    break;
                case "Defend":
                    int startIndex = Integer.parseInt ( commandline[1] );
                    int endIndex = Integer.parseInt ( commandline [2] );
                    int power = Integer.parseInt ( commandline [3] );
                    if (startIndex >=0 && endIndex < pirateShips.length){
                        for ( int i = startIndex ; i <= endIndex  ; i++ ) {
                            pirateShips [i] -= power;
                            if (pirateShips [i] <= 0){
                                System.out.println ( "You lost! The pirate ship has sunken." );
                                return;
                            }
                        }
                    }
                    break;
                case "Repair":
                    int shipToRepair = Integer.parseInt ( commandline [1] );
                    int healthToAdd = Integer.parseInt ( commandline [2] );
                    if ( shipToRepair >= 0 && shipToRepair < pirateShips.length ){
                        if (pirateShips [shipToRepair] + healthToAdd <= maximumHealth){
                            pirateShips [shipToRepair] += healthToAdd;
                        }else{
                            pirateShips [shipToRepair] = maximumHealth;
                        }
                    }
                    break;
                case "Status":
                    int counterShipsNeedingRepair = 0;
                    for ( int pirateShip : pirateShips ) {
                        if ( pirateShip < maximumHealth * 0.2 ) {
                            counterShipsNeedingRepair++;
                        }
                    }
                    System.out.printf ( "%d sections need repair.%n", counterShipsNeedingRepair );
                    break;
            }
            commandline = scan.nextLine ().split ( " " );
        }
        System.out.printf ( "Pirate ship status: %d%n", sumHealth ( pirateShips ) );
        System.out.printf ( "Warship status: %d%n", sumHealth ( warShips ) );
    }
    public static int sumHealth (int [] ships){
        int sum = 0;
        for ( int element: ships ) {
            sum +=element;
        }
        return sum;
    }
}
