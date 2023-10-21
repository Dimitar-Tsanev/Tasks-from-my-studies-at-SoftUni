import java.util.Scanner;

public class CounterStrike {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );

        int initialEnergy = Integer.parseInt ( scan.nextLine ( ) );
        int winCounter = 0;
        String input = scan.nextLine ( );

        while (!input.equals ( "End of battle" )) {
            int distanceToEnemy = Integer.parseInt ( input );

            if ( initialEnergy - distanceToEnemy >= 0 ) {
                initialEnergy -= distanceToEnemy;
                winCounter++;

                if ( winCounter % 3 == 0 ) {
                    initialEnergy += winCounter;
                }
            } else if (initialEnergy - distanceToEnemy < 0){
                System.out.printf (
                        "Not enough energy! Game ends with %d won battles and %d energy%n",
                        winCounter, initialEnergy );
                return;
            }
            input = scan.nextLine ( );
        }
        System.out.printf ( "Won battles: %d. Energy left: %d%n", winCounter, initialEnergy );
    }
}
