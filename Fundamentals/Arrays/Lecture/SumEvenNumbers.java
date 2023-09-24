package Lecture;

import java.util.Arrays;
import java.util.Scanner;

public class SumEvenNumbers {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        String input = scan.nextLine ( );
        String [] items = input.split ( " " );
        int [] array = Arrays.stream ( items ).mapToInt ( e-> Integer.parseInt ( e )).toArray( );
        int evenSum = 0;
        for ( int position = 0 ; position < array.length ; position++ ) {
            if ( array[position] % 2 == 0){
                evenSum += array [position];
            }
        }
        System.out.println ( evenSum );
    }
}
