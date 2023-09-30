package Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayRotation {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        int [] array = Arrays.stream ( scan.nextLine ().split ( " " ) )
                .mapToInt ( Integer::parseInt )
                .toArray ();
        int positions = Integer.parseInt ( scan.nextLine ( ) );
        if (positions >= array.length){
            positions -= array.length;
        }
        for ( int repeats = 0 ; repeats < positions ; repeats++ ) {
            int keeper = array [0];
            for ( int index = 0; index < array.length-1; index++ ) {
                array [index] = array [index+1];
            }
            array [array.length-1] = keeper;
        }
        for ( Integer element:
              array ) {
            System.out.print (element + " " );
        }
    }
}
