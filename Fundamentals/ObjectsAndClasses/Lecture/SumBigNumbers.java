import java.math.BigInteger;
import java.util.Scanner;

public class SumBigNumbers {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        BigInteger firstNumber = new BigInteger ( scan.nextLine () );
        BigInteger secondNumber = new BigInteger ( scan.nextLine () );

        BigInteger sum = firstNumber.add (secondNumber);
        System.out.println ( sum );
    }
}
