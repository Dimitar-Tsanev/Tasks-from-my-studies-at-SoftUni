import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidPassword {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        int numberOfLines = Integer.parseInt ( scanner.nextLine () );

        Pattern passwordPattern = Pattern.compile ( "^(_\\.+)(?<core>[A-Z][0-9a-zA-Z]{4,}[A-Z])(_\\.+)$" );

        for ( int i = 1 ; i <= numberOfLines  ; i++ ) {

            String input = scanner.nextLine ( );

            Matcher passwordMatcher = passwordPattern.matcher ( input );

            if (passwordMatcher.find ()){
                String core = passwordMatcher.group ("core");

                Pattern numberPattern = Pattern.compile ( "\\d");
                Matcher numberMatcher = numberPattern.matcher ( core );

                StringBuilder groupNumber = new StringBuilder ();

                while (numberMatcher.find ( )){
                    groupNumber.append ( numberMatcher.group () );

                }
                if (groupNumber.isEmpty ()){ // in judge system must be groupNumber.length () == 0
                    System.out.println ( "Group: default" );

                }else {
                    System.out.println ( "Group: " + groupNumber);

                }
            }else {
                System.out.println ( "Invalid pass!" );

            }
        }
    }
}
