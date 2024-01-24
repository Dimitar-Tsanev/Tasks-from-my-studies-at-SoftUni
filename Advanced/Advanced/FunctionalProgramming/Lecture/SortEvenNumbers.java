import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        List<Integer> numbers = Arrays.stream ( scanner.nextLine ()
                .split ( ",\\s+" ) ).map ( Integer::parseInt )
                .filter ( x -> x % 2 == 0 )
                .collect( Collectors.toList());

        System.out.println ( numbers
                .toString ()
                .replaceAll ( "[\\[\\]]", "" ) ) ;

        List <Integer> sorted = numbers
                .stream ()
                .sorted ((x1,x2) -> x1.compareTo ( x2 ))
                .collect( Collectors.toList());

        System.out.println ( sorted
                .toString ()
                .replaceAll ( "[\\[\\]]", "" ));

    }
}
