import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.UnaryOperator;

public class ReverseAndExclude {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        int[] array = Arrays.stream( scanner.nextLine ().split ( "\\s+" ) )
                .mapToInt ( Integer::parseInt )
                .toArray ();

        int divisor = Integer.parseInt ( scanner.nextLine ( ) );

        if (divisor == 0){
            return;

        }

        BiPredicate<Integer, Integer> exclude = ( n, d) -> n % d != 0;

        UnaryOperator<int[]> reverse = x ->{
            for ( int i = 0 ; i < x.length/2 ; i++ ) {
                int current = x[i];
                x[i] = x[x.length - 1 - i];
                x[x.length -1 - i] = current;
            }
            return x;
        };

        int[] result = reverse.apply ( Arrays.stream( array )
                .filter ( n -> exclude.test ( n,divisor ) )
                .toArray ());

        System.out.println (Arrays
                .toString ( result )
                .replaceAll ( "[\\[,\\]]", "" ) );
    }
}
