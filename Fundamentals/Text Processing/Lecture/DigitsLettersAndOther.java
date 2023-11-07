import java.util.Scanner;

public class DigitsLettersAndOther {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        String text = scanner.nextLine ( );

        StringBuilder digits = new StringBuilder ();
        StringBuilder letters = new StringBuilder ();
        StringBuilder others = new StringBuilder ();

        for ( int i = 0 ; i < text.length () ; i++ ) {
            char current = text.charAt ( i );

            if (Character.isDigit ( current )){
                digits.append ( current );

            } else if ( Character.isLetter ( current ) ) {
                letters.append ( current );

            }else{
                others.append ( current );
            }
        }

        System.out.println ( digits );
        System.out.println ( letters );
        System.out.println ( others );
    }
}
