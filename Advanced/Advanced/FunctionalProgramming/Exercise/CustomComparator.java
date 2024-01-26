import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class CustomComparator {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        Comparator<Integer> sortEvenAndOdd = (x, y) ->{
            if (x % 2 != 0 && y % 2 == 0){
                return 1;

            } else if ( x % 2 == 0 && y % 2 != 0 ) {
                return -1;

            }else {
                return  x.compareTo ( y );
            }
        };

        Arrays.stream ( scanner.nextLine ().split ( "\\s+" ) )
                .map ( Integer::parseInt )
                .sorted (sortEvenAndOdd)
                .forEach ( x-> System.out.print (x + " " ) );
    }
}
