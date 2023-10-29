import java.util.*;

public class WordSynonyms {
    public static void main ( String[] args ) {

        Scanner scan = new Scanner ( System.in );

        int numberOfWords = Integer.parseInt ( scan.nextLine ( ) );

        LinkedHashMap <String, ArrayList<String>> synonyms = new LinkedHashMap<> ( );

        for ( int i = 1 ; i <=numberOfWords  ; i++ ) {
            String word = scan.nextLine ();
            String synonym = scan.nextLine ( );

            synonyms.putIfAbsent ( word, new ArrayList<> ( ) );
            synonyms.get(word).add ( synonym );
        }
        for ( Map.Entry <String, ArrayList<String>> entry: synonyms.entrySet () ) {
            System.out.println (  entry.getKey ( )  + " - " + String.join ( ", ", entry.getValue ()));
        }
    }
}
