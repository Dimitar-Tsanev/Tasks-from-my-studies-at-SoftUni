import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryConverter {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        int num = Integer.parseInt ( scanner.nextLine () );

        if ( num == 0 ){
            System.out.println ( num );
            return;
        }

        ArrayDeque <Integer> binary = new ArrayDeque<> ();

        while (num != 0){
            binary.push ( num % 2 );
            num /= 2;

        }
        binary.forEach ( e -> System.out.print (binary.pop () ) );

        System.out.println ( );
    }
}
