import java.util.Scanner;

public class Login {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        String username = scan.nextLine ( );
        String password = "";
        for ( int position = username.length ()-1; position >=0; position-- ) {
            password = password  + username.charAt(position);
        }
        String input = scan.nextLine ( );
        int incorrectCounter = 0;
        while (!input.equals ( password ) ){
            incorrectCounter++;
            if (incorrectCounter == 4 ){
                System.out.printf ( "User %s blocked!", username);
                return;
            }
            System.out.println ( "Incorrect password. Try again." );
            input = scan.nextLine ( );
        }
        System.out.printf ( "User %s logged in.", username );
    }
}
