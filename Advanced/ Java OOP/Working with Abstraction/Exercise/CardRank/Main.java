package CardRank;

import java.util.Scanner;

public class Main {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        String input = scanner.nextLine ( );

        System.out.println ( input + ":" );

        for ( CardRank cardRank : CardRank.values ( ) ) {
            System.out.printf ( "Ordinal value: %s; Name value: %s%n", cardRank.ordinal ( ), cardRank );
        }
    }
}

