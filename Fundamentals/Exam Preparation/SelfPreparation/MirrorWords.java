import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        String input = scanner.nextLine ( );

        String regex = "([@#])(?<wordOne>[a-zA-Z]{3,})\\1{2}(?<wordTwo>[a-zA-Z]{3,})\\1";

        Pattern pattern = Pattern.compile ( regex );
        Matcher matcher = pattern.matcher ( input );

        int foundPairs = 0;

        List<String> pairs = new ArrayList<> ();

        while (matcher.find ()){
            foundPairs++;

            String wordOne = matcher.group ( "wordOne");
            String wordTwo = matcher.group ( "wordTwo");

            boolean trigger = true;

            if (wordOne.length () != wordTwo.length ()){
                trigger = false;

            } else {
                for ( int i = 0 ; i < wordOne.length () ; i++ ) {
                    if ( wordOne.charAt ( i ) != wordTwo.charAt ( wordTwo.length () - i - 1 ) ){
                        trigger = false;
                        break;

                    }
                }
            }
            if ( trigger ){
                String pair = wordOne + " <=> " + wordTwo;

                pairs.add ( pair );

            }
        }

        if ( foundPairs == 0 ){
            System.out.println ( "No word pairs found!");

        }else {
            System.out.println ( foundPairs + " word pairs found!" );

        }
        if ( pairs.isEmpty () ){
            System.out.println ( "No mirror words!" );

        }else {
            System.out.println ("The mirror words are:" );
            System.out.println ( String.join ( ", ",pairs ) );

        }
    }
}
