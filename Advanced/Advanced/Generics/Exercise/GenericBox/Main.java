package GenericBox;

import java.util.Scanner;

public class Main {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        int numberOfLines = Integer.parseInt ( scanner.nextLine () );

        for ( int i = 0 ; i < numberOfLines ; i++ ) {
            Box box = new Box ( scanner.nextLine ());

            System.out.println ( box );

        }
    }
}
