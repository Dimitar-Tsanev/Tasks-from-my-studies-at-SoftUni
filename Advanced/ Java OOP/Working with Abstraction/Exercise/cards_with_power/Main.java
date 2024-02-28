package cards_with_power;

import java.util.Scanner;

public class Main {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        String rank = scanner.nextLine ( );
        String suit = scanner.nextLine ();

        System.out.printf ( "Card name: %s of %s; Card power: %d%n",
                CardRank.valueOf ( rank.toUpperCase () ),
                CardSuit.valueOf ( suit.toUpperCase () ),
                CardRank.valueOf ( rank.toUpperCase () ).getPower () +
                        CardSuit.valueOf ( suit.toUpperCase () ).getPower () );
    }
}
