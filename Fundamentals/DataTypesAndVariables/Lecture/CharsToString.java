package DataTypesAndVariablesLecture;

import java.util.Scanner;

public class CharsToString {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        char char1 = scan.nextLine ().charAt (0);
        char char2 = scan.nextLine ().charAt (0);
        char char3 = scan.nextLine ().charAt (0);

        System.out.println ( String.valueOf ( char1) + char2 + char3 );
    }

}
