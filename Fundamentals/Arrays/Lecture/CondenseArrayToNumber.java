package Lecture;


import java.util.Arrays;
import java.util.Scanner;

public class CondenseArrayToNumber {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        String input = scan.nextLine ();
        String [] items = input.split ( " " );
        int [] array = Arrays.stream ( items ).mapToInt ( Integer::parseInt ).toArray ();
        while (array.length > 1) {
            int[] condense = new int[(array.length - 1)];
            for ( int position = 0 ; position < condense.length ; position++ ) {
                    condense[position] = array[position] + array[position + 1];

            }
            array = condense;
        }
        System.out.println ( array [0] );
    }
}
