import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        ArrayDeque <Integer> elements = new ArrayDeque<> ();

        int[] commands = Arrays.stream ( scanner.nextLine ().split ( " " ) )
                .mapToInt ( Integer::parseInt )
                .toArray ();

        int[] digits = Arrays.stream ( scanner.nextLine ().split ( " " ) )
                .mapToInt ( Integer::parseInt )
                .toArray ();

        for ( int i = 0 ; i < commands [0] ; i++ ) {
            elements.push ( digits[i] );

        }
        for ( int i = 0 ; i < commands[1] ; i++ ) {
            elements.pop ();

        }
        if (elements.isEmpty ()){
            System.out.println (0 );

        }else if (elements.contains ( commands[2] )){
            System.out.println ( "true" );

        }else {
            int min = Integer.MAX_VALUE;

            while (!elements.isEmpty ()){
                if (min > elements.peek ()){
                    min = elements.pop ();

                }else{
                    elements.pop ();

                }
            }
            System.out.println ( min );

        }
    }
}
