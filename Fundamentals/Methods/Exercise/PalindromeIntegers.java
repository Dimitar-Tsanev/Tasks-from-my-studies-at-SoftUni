import java.util.Scanner;

public class PalindromeIntegers {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        String input = scan.nextLine ( );
        while (!input.equals ( "END" )) {

            printResult ( input );
            input = scan.nextLine ( );
        }
    }

    public static void printResult ( String input ) {

        boolean palindrome = checksForPalindrome ( input );
        System.out.println ( palindrome );

    }
    public static boolean checksForPalindrome ( String input ) {
        boolean palindrome = true;
        for ( int i = 0 ; i < input.length ( ) / 2 ; i++ ) {
            if ( input.charAt ( i ) != input.charAt ( input.length ( ) - 1 - i ) ) {
                palindrome = false;
                break;
            }
        }
        return palindrome;
    }
}
