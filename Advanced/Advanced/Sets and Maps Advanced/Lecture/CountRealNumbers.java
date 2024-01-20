import java.util.*;
import java.util.stream.Collectors;

public class CountRealNumbers {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        Map<Double, Integer> numbers = new LinkedHashMap<> (  );

        List<Double> numbersList = Arrays.stream ( scanner.nextLine ().split ( "\\s+" ) )
                .map ( Double::parseDouble )
                .collect( Collectors.toList());

        for ( Double currentNumber : numbersList ) {
            numbers.putIfAbsent ( currentNumber, 0 );
            numbers.put ( currentNumber, numbers.get ( currentNumber ) + 1 );

        }
        numbers.forEach ( (k,v)-> System.out.printf ( "%.1f -> %d%n",k, v ) );
    }
}
