import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        String text = scanner.nextLine ();

        Map<Character,Integer> charactersCounts = new TreeMap<> (  );

        for ( Character character: text.toCharArray () ){
            charactersCounts.putIfAbsent ( character,0 );
            charactersCounts.put ( character, charactersCounts.get ( character ) + 1 );

        }
        charactersCounts.forEach ( (k,v) -> System.out.printf ( "%c: %d time/s%n",k,v ) );
    }
}
