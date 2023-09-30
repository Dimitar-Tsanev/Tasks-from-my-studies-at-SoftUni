package Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        int [] array = Arrays.stream ( scan.nextLine ().split ( " " ) )
                .mapToInt ( Integer::parseInt )
                .toArray ();
        boolean trigger = true;
        for ( int currentElement = 0 ; currentElement < array.length ; currentElement++ ) {
            for ( int compareElement = currentElement + 1 ; compareElement < array.length ; compareElement++ ) {
                if (array[currentElement] <= array [compareElement]){
                    trigger = false;
                    break;
                }
            }
            if(trigger){
                System.out.print (array [currentElement] + " " );
            }
            trigger = true;
        }
    }
}
