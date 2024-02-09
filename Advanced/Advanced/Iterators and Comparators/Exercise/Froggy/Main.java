package Froggy;

import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        Lake collection = new Lake ( );

        String input = scanner.nextLine ( );

        while (!"END".equals ( input )) {
            Integer[] elements = Arrays.stream ( input.split ( ", " ) )
                    .map ( Integer::parseInt )
                    .toArray ( Integer[]::new );

            collection = new Lake( elements );

            input = scanner.nextLine ( );
        }
        int counter = 0;

        for ( Integer num : collection ) {
            if ( counter == collection.size ( ) - 1) {
                System.out.println ( num );

            } else {
                System.out.print ( num + ", " );
            }
            counter++;
        }
    }
}
