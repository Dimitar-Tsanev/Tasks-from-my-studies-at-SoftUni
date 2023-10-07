import java.text.DecimalFormat;
import java.util.Scanner;

public class FactorialDivision {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        double num1 = Double.parseDouble ( scan.nextLine ( ) );
        double num2 = Double.parseDouble ( scan.nextLine ( ) );
        double result = divide ( num1,num2 );
        System.out.printf ( new DecimalFormat ( "0.00" ).format ( result ));

    }
    public static double divide (double num1, double num2){
        num1 = calculateFactorial ( num1 );
        num2 = calculateFactorial ( num2 );
        return num1  / num2;
    }
    public static double calculateFactorial (double num){
        double result = 1;
        for ( int i = 1 ; i <= num ; i++ ) {
            result *= i;
        }
        return result;
    }
}
