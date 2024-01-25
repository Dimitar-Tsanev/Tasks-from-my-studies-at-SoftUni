import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class KnightsofHonor {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        String[] input = scanner.nextLine ().split ( "\\s+" );

        Consumer<String> printLn = x -> System.out.println ( "Sir " + x );

        Arrays.stream ( input ).forEach ( printLn );

    }
}
