import java.util.Scanner;

public class ReverseStrings {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        String text = scanner.nextLine ();

        while (!text.equals ( "end" )){
            StringBuilder reversedText = new StringBuilder ();

            for ( int i = text.length () -1 ; i >= 0  ; i-- ) {
                reversedText.append ( text.charAt ( i ) );
            }

            System.out.printf ("%s = %s%n",text, reversedText);
            text = scanner.nextLine ();
        }

    }
}
