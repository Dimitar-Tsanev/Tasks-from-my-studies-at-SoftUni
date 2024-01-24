import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.Scanner;

public class SumNumbersSecondWaySolution {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        IntSummaryStatistics  numbers = Arrays.stream( scanner.nextLine ().split ( ",\\s+" ) )
                .mapToInt ( Integer::parseInt )
                .summaryStatistics ();

        System.out.printf ( "Count = %d%n" +
                "Sum = %d%n", numbers.getCount (), numbers.getSum () );
    }
}
