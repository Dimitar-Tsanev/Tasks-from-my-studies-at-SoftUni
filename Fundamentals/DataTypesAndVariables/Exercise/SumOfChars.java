package DataTypesAndVariablesExercise;

import java.util.Scanner;

public class SumOfChars {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        int numberOfChars = Integer.parseInt ( scan.nextLine () );
        int sumOfAscii = 0;
        for ( int repeats = 1 ; repeats <= numberOfChars  ; repeats++ ) {
            char character = scan.nextLine ().charAt ( 0 );
            sumOfAscii += character;
        }
        System.out.printf ( "The sum equals: %d", sumOfAscii );
    }
}
