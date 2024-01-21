import java.util.*;
import java.util.stream.Collectors;

public class Largest3Numbers {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        List<Integer> sortedNumbers = Arrays.stream ( scanner.nextLine ().split ( "\\s+" ) ).map ( Integer::parseInt ).sorted ( Comparator.reverseOrder ( ) ).collect( Collectors.toList());
        if (sortedNumbers.size () < 3){
            sortedNumbers.forEach ( n -> System.out.print ( n + " " ) );
            return;
        }
        for ( int i = 0 ; i < 3 ; i++ ) {
            System.out.print ( sortedNumbers.get ( i ) + " " );
        }
    }
}
