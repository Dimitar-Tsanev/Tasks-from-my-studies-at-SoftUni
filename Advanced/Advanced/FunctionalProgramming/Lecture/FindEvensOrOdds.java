import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.stream.IntStream;

public class FindEvensOrOdds {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        int[] bounds = Arrays.stream ( scanner.nextLine ().split ( "\\s+" ) )
                .mapToInt ( Integer::parseInt )
                .toArray ();

        String command = scanner.nextLine ();

        BiPredicate<String,Integer> tetToCommand = (c,num) -> "odd".equals ( c ) == (num % 2 != 0);

        int[] result = IntStream.rangeClosed(bounds[0], bounds[1] ).filter ( x -> tetToCommand.test ( command,x ) ).toArray ();

        Arrays.stream( result ).forEach ( x-> System.out.print ( x + " " ) );
    }
}
