package pointIn_rectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        int[] rectangleCoordinates = Arrays.stream ( scanner.nextLine ( ).split ( "\\s+" ) )
                .mapToInt ( Integer::parseInt )
                .toArray ( );

        Rectangle rectangle = new Rectangle ( rectangleCoordinates[0],
                rectangleCoordinates[1],
                rectangleCoordinates[2],
                rectangleCoordinates[3] );

        int coordinatesToCheck = Integer.parseInt ( scanner.nextLine () );

        for ( int i = 0 ; i < coordinatesToCheck ; i++ ) {
            int[] pointCoordinates = Arrays.stream ( scanner.nextLine ( ).split ( "\\s+" ) )
                    .mapToInt ( Integer::parseInt )
                    .toArray ( );

            Point point = new Point ( pointCoordinates[0],pointCoordinates[1] );

            System.out.println ( rectangle.contains ( point ));
        }

    }
}
