import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        String input = scanner.nextLine ( );
        StringBuilder result = new StringBuilder ( );

        if ( input.isEmpty ( ) ) {
            return;

        }
        if ( result.isEmpty () ) { // in "judge system" must be replaced with -> result.length () == 0
            result.append ( input.charAt ( 0 ) );

        }
        for ( int i = 1 ; i < input.length ( ) ; i++ ) {
            if ( input.charAt ( i ) != result.charAt ( result.length ( ) - 1 ) ) {
                result.append ( input.charAt ( i ) );

            }
        }
        System.out.println ( result );
    }
}
