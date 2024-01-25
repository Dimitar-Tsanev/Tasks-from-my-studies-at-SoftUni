import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        Function<int[], Integer> getMinimum =  x -> {
            int min = Integer.MAX_VALUE;
            for ( Integer num : x ) {
                min = Math.min ( min, num );
            }
            return min;
        };

        int[] arr = Arrays.stream(scanner.nextLine ().split ( "\\s+" ))
                .mapToInt ( Integer::parseInt )
                .toArray ();

        int min = getMinimum.apply ( arr );

        System.out.println ( min );
    }
}
