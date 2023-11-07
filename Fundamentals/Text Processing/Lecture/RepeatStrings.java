import java.util.Scanner;

public class RepeatStrings {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        String[] stringArray = scanner.nextLine ().split ( " " );

        StringBuilder repeated = new StringBuilder ();

        for ( String word: stringArray ) {
            repeated.append ( word.repeat ( word.length ( ) ) );
        }
        System.out.println (repeated );
    }
}
