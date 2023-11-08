import java.util.Scanner;

public class MultiplyBigNumber {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );

        String integerAsString = scan.nextLine ( );
        int multiplier = Integer.parseInt ( scan.nextLine ( ) );

        if (multiplier == 0){
            System.out.println ( "0" );
            return;

        }else  if ( integerAsString.charAt ( 0 ) == '0' ) {
            StringBuilder zeroRemoved = new StringBuilder ( );

            for ( int i = 0 ; i < integerAsString.length ( ) ; i++ ) {
                if ( integerAsString.charAt ( i ) != '0' ) {
                    zeroRemoved.append ( integerAsString.charAt ( i ) );
                }
            }
            integerAsString = zeroRemoved.toString ( );

            if ( integerAsString.isEmpty ( ) ) {
                System.out.println ( "0" );
                return;
            }
        }

        StringBuilder resultReversed = new StringBuilder ( );
        int remainder = 0;

        for ( int i = integerAsString.length ( ) - 1 ; i >= 0 ; i-- ) {
            int currentNumber = Integer.parseInt ( String.valueOf ( integerAsString.charAt ( i ) ) );

            int multipliedNum = currentNumber * multiplier;
            multipliedNum += remainder;

            if ( multipliedNum > 9 ) {
                remainder = multipliedNum / 10;

                multipliedNum = multipliedNum % 10;

            } else {
                remainder = 0;

            }
            resultReversed.append ( multipliedNum );
        }

        if ( remainder > 0 ) {
            resultReversed.append ( remainder );
        }

        System.out.println ( resultReversed.reverse ( ) );
    }
}
