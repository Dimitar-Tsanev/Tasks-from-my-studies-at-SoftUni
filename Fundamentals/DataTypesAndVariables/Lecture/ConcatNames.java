package DataTypesAndVariablesLecture;

import java.util.Scanner;

public class ConcatNames {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        String firstName = scan.nextLine ( );
        String lastName = scan.nextLine ( );
        String delimiter = scan.nextLine ( );

        System.out.println (firstName + delimiter + lastName );
    }
}
