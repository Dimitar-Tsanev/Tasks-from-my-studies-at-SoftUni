import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        String[] input = scanner.nextLine ( ).split ( "\\s+" );

        double finalSum = 0;

        for ( String sequence : input ) {

            char firstLetter = sequence.charAt ( 0 );
            int firstLetterIndex = getAlphabetIndex ( firstLetter );

            int number = Integer.parseInt ( sequence.substring ( 1, sequence.length ( ) - 1 ) );

            double currentSum;

            if ( isUppercase ( firstLetter ) ) {
                currentSum = number * 1.0 / firstLetterIndex;

            } else {
                currentSum = number * 1.0 * firstLetterIndex;

            }

            char finalLetter = sequence.charAt ( sequence.length ( ) - 1 );
            int finalLetterIndex = getAlphabetIndex ( finalLetter );

            if ( isUppercase ( finalLetter ) ) {
                currentSum -= finalLetterIndex;

            } else {
                currentSum += finalLetterIndex;
            }

            finalSum += currentSum;

        }
        System.out.printf ( "%.2f", finalSum );

    }

    public static int getAlphabetIndex ( char character ) {

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int charPosition = 0;
        character = String.valueOf ( character ).toLowerCase ( ).charAt ( 0 );

        for ( int i = 0 ; i < alphabet.length ( ) ; i++ ) {
            if ( character == alphabet.charAt ( i ) ) {
                charPosition = i + 1;
                break;
            }
        }
        return charPosition;
    }

    public static boolean isUppercase ( char character ) {

        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        for ( int i = 0 ; i < alphabet.length ( ) ; i++ ) {
            if ( character == alphabet.charAt ( i ) ) {
                return false;
            }
        }
        return true;
    }
}