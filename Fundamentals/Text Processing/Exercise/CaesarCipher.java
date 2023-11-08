import java.util.Scanner;

public class CaesarCipher {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        String input = scanner.nextLine ( );

        char[] charArray = input.toCharArray ();

        StringBuilder result = new StringBuilder (  );

        for ( char character: charArray ) {
            character += 3;
            result.append ( character );
        }

        System.out.println ( result );
    }
}
