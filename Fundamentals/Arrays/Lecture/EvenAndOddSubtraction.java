package Lecture;

import java.util.Arrays;
import java.util.Scanner;

public class EvenAndOddSubtraction {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        String input = scan.nextLine ();
        String [] items = input.split ( " " );
        int [] array = Arrays.stream ( items ).mapToInt ( Integer::parseInt ).toArray ();
        int evenSum = 0;
        int oddSum = 0;
        for ( int i:array) {
            if (i%2 == 0){
                evenSum += i;
            }else{
                oddSum += i;
            }
        }
        int difference = evenSum-oddSum;
        System.out.println ( difference );
    }
}
