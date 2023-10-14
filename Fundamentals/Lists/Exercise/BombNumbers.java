import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main ( String[] args ) {

        Scanner scan = new Scanner ( System.in );

        List<Integer> numbers =
                Arrays.stream ( scan.nextLine ( ).split ( " " ) )
                        .map ( Integer::parseInt )
                        .collect ( Collectors.toList ( ) );

        int[] bombAndPower =
                Arrays.stream ( scan.nextLine ( ).split ( " " ) )
                        .mapToInt ( Integer::parseInt )
                        .toArray ( );

        for ( int i = 0 ; i < numbers.size ( ) ; i++ ) {
            int numberToBomb = bombAndPower[0];
            int power = bombAndPower[1];

            if ( numbers.get ( i ) == numberToBomb ) {
                int toStartRemoving = i - power;
                int toStopRemoving = i + power;

                if ( toStartRemoving < 0 ) {
                    toStartRemoving = 0;
                }
                if ( toStopRemoving > numbers.size ( ) - 1 ) {
                    toStopRemoving = numbers.size ( ) - 1;
                }
                if ( toStopRemoving >= toStartRemoving ) {
                    numbers.subList ( toStartRemoving, toStopRemoving + 1 ).clear ( );
                    i = - 1;
                }
            }
        }
        int sumOfTheRemainElements = 0;

        for ( int element : numbers ) {
            sumOfTheRemainElements += element;
        }

        System.out.println ( sumOfTheRemainElements );
    }
}
