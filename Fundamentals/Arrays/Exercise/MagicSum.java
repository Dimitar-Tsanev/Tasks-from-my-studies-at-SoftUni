package Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MagicSum {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        int [] array = Arrays.stream(scan.nextLine ().split ( " " ))
                .mapToInt ( Integer::parseInt )
                .toArray ();
        int magicNumber = Integer.parseInt ( scan.nextLine ( ) );
        for ( int currentElement = 0; currentElement < array.length - 1; currentElement++ ) {
            for ( int checker = currentElement + 1; checker < array.length; checker++ ) {
                if ( array[currentElement] + array [checker] == magicNumber) {
                    System.out.println ( array [currentElement] + " " + array[checker] );
                }
            }
        }
    }
}
