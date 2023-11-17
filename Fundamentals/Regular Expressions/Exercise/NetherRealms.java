import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        String[] demonsNames = scanner.nextLine ( ).split ( ",\\s*" );
        for ( int i = 0 ; i < demonsNames.length - 1 ; i++ ) {
            demonsNames [i] = demonsNames[i].replaceAll ( "[,\\s]*", "" );
        }

        for ( String demon : demonsNames ) {
            if ( demon.isEmpty ( ) ){ //in judge system must be demon.length () == 0
                continue;
            }
            int health = calculateHealth ( demon );
            double attack = calculateAttack ( demon );

            attack = manipulateAttack ( demon, attack );

            System.out.printf ( "%s - %d health, %.2f damage%n", demon, health, attack );
        }
    }

    public static int calculateHealth ( String demon ) {
        int health = 0;

        Pattern pattern = Pattern.compile ( "[^0-9+\\-*/.]*" );
        Matcher matcher = pattern.matcher ( demon );

        StringBuilder characterToSum = new StringBuilder ( );

        while (matcher.find ( )) {
            characterToSum.append ( matcher.group ( ) );
        }
        for ( char character : characterToSum.toString ( ).toCharArray ( ) ) {
            health += character;
        }
        return health;
    }

    public static double calculateAttack ( String demon ) {
        double attack = 0;

        Pattern pattern = Pattern.compile ( "[+-]*\\d+[.\\d+]*" );
        Matcher matcher = pattern.matcher ( demon );

        while (matcher.find ( )) {
            attack += Double.parseDouble ( matcher.group ( ) );

        }
        return attack;
    }

    public static double manipulateAttack ( String demon, double attack ) {
        Pattern multiplyPattern = Pattern.compile ( "\\*" );
        Matcher multiplyMatcher = multiplyPattern.matcher ( demon );

        Pattern dividePattern = Pattern.compile ( "/" );
        Matcher divideMatcher = dividePattern.matcher ( demon );

        double divider = 0;
        double multiplayer = 0;

        while (multiplyMatcher.find ( )) {
            multiplayer++;
        }
        while (divideMatcher.find ( )) {
            divider++;
        }

        if ( multiplayer != 0 ) {
            attack = attack * Math.pow ( 2, multiplayer );
        }

        if ( divider != 0 ) {
            attack = attack / Math.pow ( 2, divider );
        }
        return attack;
    }
}
