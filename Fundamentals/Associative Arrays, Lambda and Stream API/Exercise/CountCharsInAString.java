import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInAString {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        LinkedHashMap< String, Integer> charCont = new LinkedHashMap<> ();

        String [] input = scanner.nextLine ().split ( " " );

        for (String word: input ) {
           String [] wordToChar = word.split ( "" );

            for ( String character: wordToChar ) {
                if ( charCont.containsKey ( character) ){
                    charCont.put ( character,charCont.get ( character ) +1 );

                }else{
                    charCont.put ( character, 1 );
                }
            }
        }
        for ( Map.Entry<String, Integer> set: charCont.entrySet ()) {
            System.out.printf ( "%s -> %d%n",set.getKey (),set.getValue () );
        }
    }
}


