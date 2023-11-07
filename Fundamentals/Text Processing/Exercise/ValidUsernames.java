import java.util.Scanner;

public class ValidUsernames {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        String[] userNames = scanner.nextLine ().split ( ", " );

        for ( String user: userNames ) {

            boolean validName = true;

            if (user.length () >=3 && user.length () <= 16 ) {

                for ( int i = 0 ; i < user.length ( ) ; i++ ) {

                    char current = user.charAt ( i );

                    if ( !Character.isLetter ( current ) && !Character.isDigit ( current ) ) {

                        if ( current != '-' && current != '_' ) {

                            validName = false;
                            break;
                        }
                    }
                }
            }else {
                validName = false;
            }

            if (validName){
                System.out.println ( user );
            }
        }
    }
}
