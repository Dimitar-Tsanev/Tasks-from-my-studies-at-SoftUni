import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseNumbersWithAStack {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        ArrayDeque <Integer> numbers = new ArrayDeque<> ();

        int[] digits = Arrays.stream( scanner.nextLine ().split ( " " ) )
                .mapToInt ( Integer::parseInt )
                .toArray ();

        Arrays.stream ( digits ).forEach ( numbers::push );

        numbers.forEach ( n -> System.out.print (numbers.pop () + " ") );
        System.out.println ( );
    }
}
