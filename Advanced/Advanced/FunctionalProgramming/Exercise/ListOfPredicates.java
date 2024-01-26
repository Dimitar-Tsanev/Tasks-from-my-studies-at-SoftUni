import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListOfPredicates {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        BiPredicate<List<Integer>, Integer > filterRangeDivisibleByNumbers =
                (testNumbers, currentNum) ->{

            for ( int num: testNumbers ){
               if (currentNum % num != 0){
                   return false;

               }
            }
            return true;

        };

        int upperBorder = Integer.parseInt ( scanner.nextLine ());

        List<Integer> testSequence = Arrays.stream ( scanner.nextLine ().split ( "\\s+" ) )
                .map ( Integer::parseInt )
                .collect( Collectors.toList());

       IntStream.rangeClosed ( 1, upperBorder).filter ( x -> filterRangeDivisibleByNumbers.test (testSequence,x) ).forEach ( x -> System.out.print ( x + " "  ) ) ;

    }
}
