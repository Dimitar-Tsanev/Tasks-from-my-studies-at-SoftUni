package Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class TheLift {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        int peoples = Integer.parseInt ( scan.nextLine ( ) );
        int [] lift = Arrays.stream ( scan.nextLine ().split ( " " ) )
                .mapToInt ( Integer::parseInt )
                .toArray ();
        for ( int wagon = 0 ; wagon < lift.length ; wagon++ ) {
            if (lift [wagon] < 4 && peoples > 4 - lift [wagon]) {
                peoples -= 4 - lift[wagon];
                lift [wagon] = 4;
            } else if ( lift[wagon] < 4 && peoples <= 4 - lift[wagon]) {
                lift [wagon] += peoples;
                peoples = 0;
            }
            if (peoples == 0 && (lift[wagon] < 4 || wagon != lift.length-1)){
                System.out.println ( "The lift has empty spots!" );
                break;
            }
        }
        if ( peoples > 0) {
            System.out.printf ( "There isn't enough space! %d people in a queue!%n", peoples );
        }
        for ( Integer element : lift ) {
            System.out.print ( element + " " );
        }
    }
}
