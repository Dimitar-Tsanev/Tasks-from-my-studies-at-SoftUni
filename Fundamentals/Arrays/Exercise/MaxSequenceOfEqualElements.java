package Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        int [] array = Arrays.stream ( scan.nextLine ().split ( " " ) )
                .mapToInt ( Integer::parseInt )
                .toArray ();
        int maxLength = 0;
        int currentLength = 0;
        int bestItem = 0;
        for ( int index = 0 ; index < array.length-1 ; index++ ) {
            if (array [index] == array[index+1]){
                currentLength++;
            }else{
                currentLength = 0;
            }
            if (currentLength > maxLength){
                maxLength = currentLength;
                bestItem = array[index];
            }
        }
        for ( int i = 0 ; i <= maxLength ; i++ ) {
            System.out.print ( bestItem + " " );
        }

    }
}
