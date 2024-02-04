package GenericSwapMethodIntegers;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        int numberOfLines = Integer.parseInt ( scanner.nextLine () );

        Boxes <Box<Integer>> boxes = new Boxes<> ();

        for ( int i = 0 ; i < numberOfLines ; i++ ) {
            Box<Integer>box = new Box <>(Integer.parseInt ( scanner.nextLine ()));

            boxes.add ( box );
        }
        int[] indexToSwap = Arrays.stream (scanner.nextLine ().split ( "\\s+" ) )
                .mapToInt ( Integer::parseInt )
                .toArray ();

        boxes.swap ( indexToSwap[0],indexToSwap[1] );

        System.out.println ( boxes );
    }
}
