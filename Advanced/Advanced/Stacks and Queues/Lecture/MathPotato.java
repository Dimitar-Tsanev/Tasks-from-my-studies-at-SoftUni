import java.util.PriorityQueue;
import java.util.Scanner;

public class MathPotato {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        PriorityQueue<String> currentInGame = new PriorityQueue<> ( );

        String[] namesInTheBeginning = scanner.nextLine ( ).split ( " " );
        int cycles = Integer.parseInt ( scanner.nextLine ( ) );

        for ( String name : namesInTheBeginning ) {
            currentInGame.offer ( name );

        }
        int cycle = 1;

        while (currentInGame.size ( ) > 1) {
            for ( int i = 1 ; i < cycles ; i++ ) {
                currentInGame.offer ( currentInGame.poll ( ) );

            }
            if ( isPrime ( cycle ) ) {
                System.out.println ( "Prime " + currentInGame.peek ( ) );

            } else {
                System.out.println ( "Removed " + currentInGame.poll ( ) );

            }
            cycle++;

        }
        System.out.println ( "Last is " + currentInGame.poll ( ) );
    }

    private static boolean isPrime ( int cycle ) {
        boolean trigger = cycle != 1;

        if ( cycle > 2 ){
            for ( int i = 2 ; i <= cycle/2 ; i++ ) {
                if (cycle % i == 0){
                    trigger = false;
                    break;
                }
            }
        }
        return trigger;
    }
}
