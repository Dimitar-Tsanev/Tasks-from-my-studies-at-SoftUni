import java.util.Arrays;
import java.util.Scanner;

public class NumberInRange {
    private static final String INVALID_NUMBER_MESSAGE = "Invalid number: %s";
    private static int[] range = new int[2];

    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        setRange ( scanner );
        printRange ( );

        String input = scanner.nextLine ( );
        boolean isInRange = false;

        while (!isInRange) {
            try {
                int number = Integer.parseInt ( input );

                isInRange = isInRange ( number );

                System.out.println ( "Valid number: " + number );

            } catch (IllegalArgumentException exception) {
                System.out.printf ( (INVALID_NUMBER_MESSAGE) + System.lineSeparator ( ), input );
                input = scanner.nextLine ( );

            }
        }
    }

    private static void setRange ( Scanner scanner ) {
        range = Arrays.stream ( scanner.nextLine ( )
                        .split ( "\\s+" ) )
                .mapToInt ( Integer::parseInt )
                .toArray ( );
    }

    private static void printRange () {
        System.out.printf ( "Range: [%d...%d]%n", range[0], range[1] );
    }

    private static boolean isInRange ( int number ) throws IllegalArgumentException {
        if ( range[0] > number || number > range[1] ) {
            throw new IllegalArgumentException ( String.format ( INVALID_NUMBER_MESSAGE + System.lineSeparator ( ), number ) );
        }
        return true;
    }
}
