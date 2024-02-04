package GenericCountMethodDoubles;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        List<Box<Double>> boxes = new ArrayList<> ();

        int boxesLength = Integer.parseInt ( scanner.nextLine () );

        for ( int i = 0 ; i < boxesLength ; i++ ) {
            Box<Double> box = new Box<> ( Double.parseDouble ( scanner.nextLine () ) );

            boxes.add ( box );
        }
        double valueToCompare = Double.parseDouble ( scanner.nextLine () );

        List<Box<Double>> result = boxes.stream( ).filter ( b -> b.getElement () > valueToCompare ).collect( Collectors.toList());

        System.out.println ( result.size () );
    }
}
