package DataTypesAndVariablesLecture;

import java.math.BigDecimal;
import java.util.Scanner;

public class ExactSumOfRealNumbers {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        int loopCycles = Integer.parseInt ( scan.nextLine () );
        BigDecimal sum = new BigDecimal ( 0 );
        for ( int i = 1 ; i <= loopCycles  ; i++ ) {
            BigDecimal number = new BigDecimal ( scan.nextLine () );
            sum = sum.add ( number );
        }
        System.out.println (sum );
    }
}
