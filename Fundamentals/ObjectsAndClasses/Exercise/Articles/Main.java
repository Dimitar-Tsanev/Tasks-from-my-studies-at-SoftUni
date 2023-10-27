package Articles;

import java.util.Scanner;

public class Main {
    public static void main ( String[] args ) {

        Scanner scan = new Scanner ( System.in );

        String [] articleLine = scan.nextLine ( ).split ( ", " );

        Article article = new Article (articleLine[0],articleLine[1],articleLine[2] );

        int numberOfCommands = Integer.parseInt ( scan.nextLine ( ) );
        for ( int i = 0 ; i < numberOfCommands ; i++ ) {
            String [] command = scan.nextLine ( ).split ( ": " );
            switch (command[0]) {
                case "Edit":
                    article.setContent ( command[1] );
                    break;
                case "ChangeAuthor":
                    article.setAuthor ( command [1] );
                    break;
                case "Rename":
                    article.setTitle ( command [1] );
                    break;
            }
        }
        System.out.println ( article.getInformation () );
    }
}
