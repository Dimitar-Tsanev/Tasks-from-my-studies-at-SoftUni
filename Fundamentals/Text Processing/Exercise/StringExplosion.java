import java.util.Scanner;

public class StringExplosion {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );

        String input = scan.nextLine ( );

        StringBuilder result = new StringBuilder ( );

        for ( int current = 0 ; current < input.length ( ) ; current++ ) {
            if ( input.charAt ( current ) != '>' ) {
                result.append ( input.charAt ( current ) );

            } else {
                result.append ( input.charAt ( current ));

                int power = Integer.parseInt ( String.valueOf ( input.charAt ( current + 1 ) ));
                int endIndex = current + power;

                for ( int i = current + 1 ; i <= endIndex ; i++ ) {
                    char charAtCurrentIndex = input.charAt ( i );

                    if ( charAtCurrentIndex == '>' ) {
                        result.append ( charAtCurrentIndex );
                        endIndex += Integer.parseInt ( String.valueOf ( input.charAt ( i + 1 ))) + 1;

                        if (endIndex >= input.length ()){
                            endIndex = input.length () - 1;
                        }
                    }
                }
                current = endIndex;
            }
        }
        System.out.println ( result );
    }
}
