import java.util.Scanner;

public class PasswordValidator {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        String password = scan.nextLine ( );
        validityCheck ( password );

    }
    public static void validityCheck ( String password ) {
        String result1 = checksLength ( password );
        String result2 = checksSymbols ( password );
        String result3 = checksContainingOfDigits ( password );

        if ( result1.equals ( result2 ) && result1.equals ( result3 ) ) {
            System.out.println ( result1 );
        } else {

            if ( !result1.equals ( "Password is valid" ) ) {
                System.out.println ( result1 );
            }

            if ( !result2.equals ( "Password is valid" ) ) {
                System.out.println ( result2 );
            }

            if ( !result3.equals ( "Password is valid" )) {
                System.out.println ( result3 );
            }
        }

    }

    public static String checksLength ( String password ) {
        if ( password.length ( ) >= 6 && password.length ( ) <= 10 ) {
            return "Password is valid";
        }

        return "Password must be between 6 and 10 characters";
    }

    public static String checksSymbols ( String password ) {
        boolean validity = true;

        for ( int i = 0 ; i < password.length ( ) ; i++ ) {

            if ( (password.charAt ( i ) >= 'a' && password.charAt ( i ) <= 'z') ||
                    (password.charAt ( i ) >= 'A' && password.charAt ( i ) <= 'Z') ||
                    (password.charAt ( i ) >= '0' && password.charAt ( i ) <= '9') ) {
            }else {
                validity = false;
                break;
            }
        }

        if ( validity ) {
            return "Password is valid";
        }
        return "Password must consist only of letters and digits";
    }

    public static String checksContainingOfDigits ( String password ) {
        int counter = 0;
        boolean validity = false;

        for ( int i = 0 ; i < password.length ( ) ; i++ ) {

            if ( password.charAt ( i ) >= '0' && password.charAt ( i ) <= '9' ) {
                counter++;

                if ( counter >= 2 ) {
                    validity = true;
                    break;
                }
            }
        }

        if ( validity ) {
            return "Password is valid";
        }
        return "Password must have at least 2 digits";
    }
}
