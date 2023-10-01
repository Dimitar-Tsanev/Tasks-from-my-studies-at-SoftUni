import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPower {
    public static void main ( String[] args ) {
        Scanner scan =  new Scanner ( System.in );
        double number = Double.parseDouble ( scan.nextLine ( ) );
        int power = Integer.parseInt ( scan.nextLine ( ) );
        double result = mathPower ( number,power );
        System.out.println(new DecimalFormat ("#.######").format(result));
    }
    public static double mathPower (double number, int power){
        double result = number;
        for ( int i = 1 ; i < power ; i++ ) {
            result *= number;
        }
        return result;
    }
}
