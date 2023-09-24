package Lecture;

import java.util.Scanner;

public class PrintNumbersInReverseOrder {
    public static void main ( String[] args ) {
        Scanner sc = new Scanner ( System.in );
        int num = Integer.parseInt ( sc.nextLine () );
        int [] numbers = new int [num];
        for ( int possition = 0 ; possition < num ; possition++ ) {
            numbers [possition] = Integer.parseInt ( sc.nextLine () );
        }
        for ( int position = numbers.length-1 ; position >= 0 ; position-- ) {
            System.out.print ( numbers[position] + " " );
        }
    }
}
