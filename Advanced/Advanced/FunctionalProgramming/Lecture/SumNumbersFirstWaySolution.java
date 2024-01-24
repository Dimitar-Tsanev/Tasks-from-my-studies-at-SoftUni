import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;


public class SumNumbersFirstWaySolution {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        Function<String, Integer> parseToInteger = x -> Integer.parseInt ( x );

        List<Integer> numbers = Arrays.stream ( scanner.nextLine ().split ( ",\\s+" ) )
                .map ( parseToInteger )
                .collect( Collectors.toList());

        int count = numbers.size ();
        int sum = numbers.stream ().mapToInt ( Integer::valueOf ).sum ();

        System.out.println ( "Count = " + count );
        System.out.println (  "Sum = " + sum);

    }
}
