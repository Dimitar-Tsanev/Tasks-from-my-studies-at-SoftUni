import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        String[] input = scanner.nextLine ().split ( "\\s+" );

        Consumer<String> printLn = x -> System.out.println ( x );

        Arrays.stream ( input ).forEach ( printLn );

    }
}
