package GenericBoxOfInteger;

import java.util.Scanner;

public class Main {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        int numberOfLines = Integer.parseInt ( scanner.nextLine () );

        for ( int i = 0 ; i < numberOfLines ; i++ ) {
            Box<Integer> box = new Box <> ( Integer.parseInt ( scanner.nextLine ()));

            System.out.println ( box );

        }
    }
}
