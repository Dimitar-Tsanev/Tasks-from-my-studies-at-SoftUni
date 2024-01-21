import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        Set<Integer> firstSet = new LinkedHashSet<> (  );
        Set<Integer> secondSet = new LinkedHashSet<> (  );

        int[] elementsToPutInSets = Arrays.stream ( scanner.nextLine ().split ( "\\s+" ) )
                .mapToInt ( Integer::parseInt )
                .toArray ();

        int elementsToPutInFirstSet = elementsToPutInSets[0];
        int elementsToPutInSecondSet = elementsToPutInSets[1];

        for ( int i = 0 ; i < elementsToPutInFirstSet + elementsToPutInSecondSet ; i++ ) {
            if (i < elementsToPutInFirstSet){
                firstSet.add ( Integer.parseInt ( scanner.nextLine () ) );

            }else {
                secondSet.add ( Integer.parseInt ( scanner.nextLine () ) );

            }
        }
        firstSet.stream ( ).filter ( secondSet::contains ).map ( e -> e + " " ).forEach ( System.out::print );
    }
}
