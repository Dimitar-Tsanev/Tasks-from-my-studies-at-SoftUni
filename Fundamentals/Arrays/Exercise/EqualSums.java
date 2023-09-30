package Exercise;

import java.util.Scanner;
import java.util.Arrays;
public class EqualSums {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        int [] array = Arrays.stream ( scan.nextLine ().split ( " " ) )
                .mapToInt ( Integer::parseInt )
                .toArray ();
        for ( int currentIndex = 0 ; currentIndex < array.length ; currentIndex++ ) {
            int leftSum = 0;
            int rightSum = 0;
            for ( int leftElements = 0 ; leftElements < currentIndex ; leftElements++ ) {
                leftSum += array [leftElements];
            }
            for ( int rightElements = currentIndex + 1 ; rightElements < array.length ; rightElements++ ) {
                rightSum += array[rightElements];
            }
            if (rightSum == leftSum){
                System.out.println ( currentIndex );
                return;
            }
        }
        System.out.println ( "no" );
    }
}
