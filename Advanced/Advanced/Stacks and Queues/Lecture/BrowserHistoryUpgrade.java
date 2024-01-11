import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        String page = scanner.nextLine ( );

        ArrayDeque<String> history = new ArrayDeque<> ( );
        ArrayDeque<String> forwards = new ArrayDeque<> ( );

        while (!"Home".equals ( page )) {
            if ( !"back".equals ( page ) && !"forward".equals ( page ) ) {
                forwards.clear ( );
                history.push ( page );
                System.out.println ( history.peek () );

            } else if ( "back".equals ( page ) ) {
                if ( history.size ( ) > 1 ) {
                    forwards.push ( history.pop ( ) );
                    System.out.println ( history.peek ( ) );

                }else{
                    System.out.println ( "no previous URLs" );
                }
            } else {
                if ( forwards.isEmpty ( ) ) {
                    System.out.println ( "no next URLs" );

                } else {
                    System.out.println ( forwards.peek ( ) );
                    history.push ( forwards.pop ( ) );

                }
            }

            page = scanner.nextLine ( );
        }
    }
}
