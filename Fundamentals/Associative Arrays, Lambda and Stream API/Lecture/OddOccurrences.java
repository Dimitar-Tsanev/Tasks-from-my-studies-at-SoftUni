import java.util.*;

public class OddOccurrences {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );

        String [] words = scan.nextLine ().split ( " " );

        LinkedHashMap <String, Integer> counts = new LinkedHashMap<> (  );

        for ( String word: words ) {
            String wordToLowerCase = word.toLowerCase ();

            if ( counts.containsKey ( wordToLowerCase ) ){
                counts.put ( wordToLowerCase, counts.get ( wordToLowerCase ) + 1 );

            }else {
                counts.put ( wordToLowerCase, 1 );

            }
        }
        List<String> odds = new ArrayList<> ();

        for ( Map.Entry <String, Integer> entry: counts.entrySet ( ) ) {
            if (entry.getValue () % 2 != 0){
                odds.add ( entry.getKey ( ) );
            }
        }
        System.out.println (String.join ( ", ",odds ) );
    }
}
