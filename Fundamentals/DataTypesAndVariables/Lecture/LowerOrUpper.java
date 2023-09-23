package DataTypesAndVariablesLecture;

import java.util.Scanner;

public class LowerOrUpper {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        char letter = scan.nextLine ().charAt ( 0 );
        if (letter == Character.toUpperCase(letter) ){
            System.out.println ( "upper-case" );
        }else{
            System.out.println ( "lower-case" );
        }
    }
}
