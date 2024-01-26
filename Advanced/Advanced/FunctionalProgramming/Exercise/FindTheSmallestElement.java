import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        Function<List<Integer>, Integer> findIndexOfTheSmallestElement = numbers ->{
          int index = 0;
          int smallestElement = Integer.MAX_VALUE;

            for ( int i = numbers.size () - 1 ; i >= 0  ; i-- ) {
                if (smallestElement > numbers.get ( i )){
                    index = i;
                    smallestElement = numbers.get ( i);
                }
            }
            return index;
        };

        System.out.println (  findIndexOfTheSmallestElement.apply (Arrays.stream ( scanner.nextLine ().split ( "\\s+" ) ).map ( Integer::parseInt ).collect( Collectors.toList()) ) );
    }
}
