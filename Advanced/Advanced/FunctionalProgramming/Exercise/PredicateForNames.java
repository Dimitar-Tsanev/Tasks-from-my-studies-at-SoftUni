import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiPredicate;

public class PredicateForNames {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        int maxLengthOfName = Integer.parseInt ( scanner.nextLine () );

        String[] names = scanner.nextLine ().split ( "\\s+" );

        BiPredicate <Integer, String> testName = (i,s) -> s.length () <= i;

        Arrays.stream( names ).filter ( x-> testName.test ( maxLengthOfName,x ) ).forEach ( System.out::println );
    }
}
