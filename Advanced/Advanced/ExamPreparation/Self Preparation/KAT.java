import java.util.*;
import java.util.stream.Collectors;

public class KAT {
    private static final Scanner scanner = new Scanner ( System.in );

    public static void main ( String[] args ) {
        Deque<Integer> platesStack =  fillQueue ( );
        Deque<Integer> carsQueue =fillDeque ( );

        int carsWithPlates = 0;
        int days = 0;

        while (!carsQueue.isEmpty ( ) && !platesStack.isEmpty ( )) {
            days++;

            int cars = carsQueue.poll ( );
            int plates = platesStack.pop ( );

            int difference = Math.abs ( cars - plates / 2 );

            if ( cars > plates / 2 ) {
                carsWithPlates += cars - difference;
                carsQueue.offer ( difference );

            } else {
                if ( plates / 2 > cars ) {
                    platesStack.offer ( difference * 2 );

                }
                carsWithPlates += cars;
            }

        }
        System.out.printf ( "%d cars were registered for %d days!%n",carsWithPlates,days );

        int remainingCars = sumElements(carsQueue);
        int remainingPlate = sumElements(platesStack);

        System.out.println ( remainingCars == 0 && remainingPlate == 0 ?
                "Good job! There is no queue in front of the KAT!":
                remainingCars != 0 ?
                        String.format ( "%d cars remain without license plates!",
                                remainingCars ):
                        String.format ("%d license plates remain!",
                                remainingPlate));

    }

    private static int sumElements ( Deque<Integer> elements ) {
        return elements.stream ( ).mapToInt ( element -> element ).sum ( );
    }

    private static Deque<Integer> fillDeque () {
        Deque<Integer> wormsDeque = new ArrayDeque<> ( );

        Arrays.stream ( scanner.nextLine ( ).split ( ",\\s+" ) )
                .map ( Integer::parseInt )
                .forEach ( wormsDeque::push );

        return wormsDeque;
    }

    private static Deque<Integer> fillQueue () {
        return Arrays.stream ( scanner.nextLine ( ).split ( ",\\s+" ) )
                .map ( Integer::parseInt )
                .collect ( Collectors.toCollection ( ArrayDeque::new ) );
    }
}
