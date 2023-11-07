import java.util.Scanner;

public class CharacterMultiplier {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        String[] words = scanner.nextLine ().split ( " " );

        int finalSum;

        if (words[0].length () > words [1].length () ){
            String swapper = words[0];
            words [0] = words [1];
            words [1] = swapper;
        }

        finalSum = sumMultipliedValueOfCharacters ( words[1],words[0] );

        if ( words[0].length () != words[1].length ()){
            finalSum += sumValuesOfRemainingCharacters ( words[1],words[0].length() );

        }

        System.out.println ( finalSum);
    }

    public static int sumMultipliedValueOfCharacters ( String longestWord, String shortestWord){
        int sum = 0;
        for ( int i = 0 ; i < shortestWord.length () ; i++ ) {
            sum += longestWord.charAt ( i ) * shortestWord.charAt ( i );
        }
        return sum;
    }
    public static int sumValuesOfRemainingCharacters (String word, int startIndex){
        int sum = 0;
        for ( int i = startIndex ; i < word.length () ; i++ ) {
            sum += word.charAt ( i );
        }
        return sum;
    }
}
