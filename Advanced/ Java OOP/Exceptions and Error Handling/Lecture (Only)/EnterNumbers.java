import java.util.*;

public class EnterNumbers {
    private static final int RANGE_MAXIMUM_VALUE = 100;
    private static final List<Integer> validNumbers = new ArrayList<> ( );

    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        while (validNumbers.size ( ) < 10) {

            try {
                int number = Integer.parseInt ( scanner.nextLine ( ) );
                addValidNumber ( number );

            } catch (NumberFormatException e) {
                System.out.println ( "Invalid Number!" );

            } catch (IllegalArgumentException e) {
                System.out.println ( e.getMessage ( ) );

            }
        }
        System.out.println ( validNumbers.toString ().replaceAll ( "[\\[\\]]","" ) );

    }

    private static void addValidNumber ( int number ) {
        int rangeMinimumValue;
        if ( validNumbers.isEmpty ( ) ) {
            rangeMinimumValue = 1;

        } else {
            rangeMinimumValue = validNumbers.get ( validNumbers.size ( ) - 1 );

        }
        if ( number <= rangeMinimumValue || number >= RANGE_MAXIMUM_VALUE ) {
            throw new IllegalArgumentException ( String.format (
                    "Your number is not in range %d - %d!",
                    rangeMinimumValue,
                    RANGE_MAXIMUM_VALUE ) );
        }
        validNumbers.add ( number );
    }
}
