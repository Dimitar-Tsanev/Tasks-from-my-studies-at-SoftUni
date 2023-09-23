import java.util.Scanner;

public class StrongNumber {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        int num = Integer.parseInt ( scan.nextLine () );
        int testingNum = num;
        int sum = 0;
        while (testingNum > 0){
            int factorialOf = testingNum % 10;
            int factorialSum = 1;
            for ( int i = 1 ; i <= factorialOf  ; i++ ) {
                factorialSum *= i;
            }
            sum += factorialSum;
            testingNum /=10;
        }
        if (num == sum){
            System.out.println ( "yes" );
        }else{
            System.out.println ( "no" );
        }
    }
}
