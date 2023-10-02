import java.text.DecimalFormat;
import java.util.Scanner;

public class MathOperations {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        int firstNum = Integer.parseInt ( scan.nextLine () );
        String operation = scan.nextLine ( );
        int secondNum = Integer.parseInt ( scan.nextLine ( ) );
        double result = calculator ( firstNum,operation,secondNum );
        System.out.println ( new DecimalFormat ( "#.##").format(result));
    }
    private static double calculator ( int firstNum, String operation, int secondNum){
        double result = 0.0;
        switch (operation){
            case  "/":
                result = firstNum * 1.0 / secondNum;
                break;
            case "*":
                result = firstNum * secondNum;
                break;
            case "+":
                result = firstNum + secondNum;
                break;
            case "-":
                result = firstNum - secondNum;
                break;
        }
        return result;
    }
}
