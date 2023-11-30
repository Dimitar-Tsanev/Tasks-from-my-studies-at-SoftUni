import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        int barcodesNumber = Integer.parseInt ( scanner.nextLine () );

        Pattern pattern = Pattern.compile ( "@#+(?<info>[A-Z][a-zA-Z-0-9]{4,}[A-Z])@#+" );

        for ( int i = 1 ; i <= barcodesNumber ; i++ ) {
            String input = scanner.nextLine ();

            Matcher matcher = pattern.matcher ( input );

            if (!matcher.find ()){
                System.out.println ( "Invalid barcode" );
                continue;
            }
            String info = matcher.group ("info" );

            StringBuilder group = new StringBuilder ();

            for ( char character: info.toCharArray () ) {
                if (Character.isDigit ( character )){
                    group.append ( character );
                }
            }
            if ( !group.isEmpty ( ) ) { //in judge system must be ( group.length () > 0 )
                System.out.println ( "Product group: " + group );

            }else {
                System.out.println ( "Product group: 00" );
            }
        }
    }
}
