import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        int linesNumber = Integer.parseInt ( scanner.nextLine () );

        List<String> messages = new ArrayList<> ();

        for ( int i = 1 ; i <= linesNumber  ; i++ ) {
            String input = scanner.nextLine ( );

            decryptMessage ( input,messages );
        }

        List<String> attackedPlanets = new ArrayList<> ();
        List<String> destroyedPlanets = new ArrayList<> ();

        sortsThePlanetsByAttackCommand ( messages,attackedPlanets,destroyedPlanets );

        Collections.sort ( attackedPlanets );
        Collections.sort ( destroyedPlanets );

        System.out.printf ( "Attacked planets: %d%n", attackedPlanets.size () );
        attackedPlanets.forEach ( p -> System.out.printf ( "-> %s%n", p ) );

        System.out.printf ( "Destroyed planets: %d%n", destroyedPlanets.size () );
        destroyedPlanets.forEach ( p -> System.out.printf ( "-> %s%n", p ) );
    }
    public static void decryptMessage (String input, List<String> messages){

        StringBuilder message = new StringBuilder ();

        Pattern decrypterPattern = Pattern.compile ( "([sSrRtTaA])" );
        Matcher decrypterMatcher = decrypterPattern.matcher ( input );

        int decrypter=0;

        while (decrypterMatcher.find ()){
            decrypter++;
        }

        for ( char character: input.toCharArray () ) {
            character = (char) (character - decrypter);

            message.append ( character );
        }
        messages.add ( message.toString () );
    }
    public static void sortsThePlanetsByAttackCommand (List<String> messages, List<String> attackedPlanets, List<String> destroyedPlanets ){
        for (String message: messages ) {
            Pattern messagePattern = Pattern
                    .compile ( "@(?<planet>[A-Za-z]+)[^@\\-!:>]*:(?<population>\\d+)[^@\\-!:>]*!(?<attackType>[AD])![^@\\-!:>]*->(?<soldierCount>\\d+)" );

            Matcher messageMatcher = messagePattern.matcher ( message );

            if (messageMatcher.find ()){
                if (messageMatcher.group ( "attackType" ).equals ( "A" )){
                    attackedPlanets.add ( messageMatcher.group ("planet") );

                } else {
                    destroyedPlanets.add ( messageMatcher.group ("planet") );

                }
            }
        }
    }
}