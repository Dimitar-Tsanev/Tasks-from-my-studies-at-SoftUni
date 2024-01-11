import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        String[] expression = scanner.nextLine ( ).split ( "\\s+" );

        ArrayDeque <String> arithmetics = new ArrayDeque<> ( );
        ArrayDeque <Integer> numbers = new ArrayDeque<> ();

        for ( int i = expression.length - 1 ; i >=0  ; i-- ) {
            if (i % 2 != 0){
                arithmetics.push ( expression [i] );

            }else {
                numbers.push ( Integer.parseInt ( expression [i] ));

            }
        }
        int sum = numbers.pop ();

        while (!numbers.isEmpty ()){
            if ("+".equals ( arithmetics.peek ())){
                arithmetics.pop ();
                sum += numbers.pop ();

            }else {
                arithmetics.pop ();
                sum -= numbers.pop ();

            }
        }
        System.out.println ( sum );

    }
}