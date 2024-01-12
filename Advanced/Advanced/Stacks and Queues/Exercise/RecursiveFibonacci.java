import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        int sequentialNumber = Integer.parseInt ( scanner.nextLine ( ) );

        Queue<Long> queue = new ArrayDeque<> (  );
        queue.offer ( 1L );
        queue.offer ( 1L );

        for ( int i = 0 ; i < sequentialNumber ; i++ ) {
                queue.offer ( queue.poll ( ) + queue.peek ( ) );

        }
        System.out.println ( queue.peek () );

    }
}
