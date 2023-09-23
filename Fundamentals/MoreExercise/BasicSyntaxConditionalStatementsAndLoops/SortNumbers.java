import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class SortNumbers {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        ArrayList <Integer> numbers = new ArrayList<> ( );
        int num1 = Integer.parseInt(scan.nextLine ( ) );
        int num2 = Integer.parseInt(scan.nextLine ( ) );
        int num3 = Integer.parseInt(scan.nextLine ( ) );
        numbers.add (num1);
        numbers.add (num2);
        numbers.add (num3);
        numbers.sort ( Collections.reverseOrder ( ) );
        numbers.forEach ( System.out::println );
    }
}
