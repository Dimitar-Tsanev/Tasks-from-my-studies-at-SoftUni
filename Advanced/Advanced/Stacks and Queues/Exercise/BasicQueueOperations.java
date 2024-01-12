import java.util.*;

public class BasicQueueOperations {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        int[] operations = Arrays.stream( scanner.nextLine ().split ( "\\s+" ) )
                .mapToInt ( Integer::parseInt )
                .toArray ();

        Queue<Integer> numbersQueue = new ArrayDeque<> ( );

        Arrays.stream( scanner.nextLine ().split ( "\\s+" ) )
                .mapToInt ( Integer::parseInt )
                .forEach ( numbersQueue::offer );

        for ( int i = 0 ; i < operations[1] ; i++ ) {
            numbersQueue.poll ();

        }
        if (numbersQueue.isEmpty ()){
            System.out.println ( 0 );

        }else if (numbersQueue.contains ( operations[2] )){
            System.out.println ( "true" );

        }else{
            System.out.println ( Collections.min ( numbersQueue ) );

        }
    }
}
