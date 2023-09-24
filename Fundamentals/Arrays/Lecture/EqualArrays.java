package Lecture;

import java.util.Arrays;
import java.util.Scanner;

public class EqualArrays {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        String firstInput = scan.nextLine ( );
        String [] firstArrayItems = firstInput.split ( " " );
        int [] firstArray = Arrays.stream ( firstArrayItems )
                .mapToInt ( Integer::parseInt ).toArray ();
        String secondInput = scan.nextLine ( );
        String [] secondArrayItems = secondInput.split ( " " );
        int [] secondArray = Arrays.stream ( secondArrayItems )
                .mapToInt ( Integer::parseInt ).toArray ();
        int arrayDifferenceAtIndex = 0;
        boolean trigger = true;
        int arraySum = 0;
        for ( int position = 0 ; position < firstArray.length ; position++ ) {
            if ( firstArray [position] != secondArray [position]) {
                arrayDifferenceAtIndex = position;
                trigger = false;
                break;
            }else{
                arraySum += firstArray [position];
            }
        }
        if (trigger){
            System.out.printf ( "Arrays are identical. Sum: %d",arraySum );
        }else {
            System.out.printf ( "Arrays are not identical. Found difference at %d index.", arrayDifferenceAtIndex );
        }
    }
}
