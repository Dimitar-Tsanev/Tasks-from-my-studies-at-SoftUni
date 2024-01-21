import java.util.*;
import java.util.stream.Collectors;

public class PeriodicTable {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        Set<String> uniqueChemicalElements = new TreeSet<> ();

        int lineOfCompounds = Integer.parseInt ( scanner.nextLine () );

        for ( int i = 0 ; i < lineOfCompounds ; i++ ) {
            List<String> compounds = Arrays.stream( scanner.nextLine ().split ( "\\s+" ) ).collect ( Collectors.toList ( ) );
            uniqueChemicalElements.addAll ( compounds );

        }
        uniqueChemicalElements.forEach ( e -> System.out.print ( e + " " ) );
    }
}
