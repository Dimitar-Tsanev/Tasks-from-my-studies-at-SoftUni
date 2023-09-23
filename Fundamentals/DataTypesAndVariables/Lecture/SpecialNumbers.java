package DataTypesAndVariablesLecture;

import java.util.Scanner;

public class SpecialNumbers {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        int number = Integer.parseInt ( scan.nextLine ( ) );
        for ( int i = 1 ; i <= number  ; i++ ) {
            int sumOfNumberParts = 0;
            int current = i;
            while (current > 0){
                int separator = current%10;
                sumOfNumberParts += separator;
                current /= 10;
            }
            if (sumOfNumberParts == 5 || sumOfNumberParts == 7 ||sumOfNumberParts == 11) {
                System.out.printf ( "%d -> True%n",i );
            }else{
                System.out.printf ( "%d -> False%n",i );
            }
        }
    }
}
