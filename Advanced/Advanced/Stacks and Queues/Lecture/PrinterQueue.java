import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        ArrayDeque<String> queue = new ArrayDeque<> ();

        String fileName = scanner.nextLine ();

        while (!"print".equals ( fileName )) {
            if ( "cancel".equals ( fileName ) ) {
                if ( queue.isEmpty ( ) ) {
                    System.out.println ( "Printer is on standby" );

                } else {
                    System.out.println ( "Canceled " + queue.poll ( ) );

                }
            } else {
                queue.offer ( fileName );

            }
            fileName = scanner.nextLine ( );

        }
        queue.forEach ( e -> System.out.println ( queue.poll () ) );

    }
}
