import java.util.Scanner;

public class MultiplyEvensByOdds {
    public static void main ( String[] args ) {
        Scanner scan =new Scanner ( System.in );
        int number = Math.abs ( Integer.parseInt ( scan.nextLine ( ) ) );
        int result = getMultipliedNumber ( number );
        System.out.println ( result );
    }
    private static int getMultipliedNumber (int number){
        int evenSum = getEvenSum ( number );
        int oddSum = getOddSum ( number );
        return evenSum * oddSum;
    }
    private static int getEvenSum (int number){
        int evenSum = 0;
        while (number > 0){
             int check = number % 10;
             if (check % 2 == 0)
                 evenSum += check;
             number /= 10;
        }
        return evenSum;
    }
    private static int getOddSum (int number){
        int oddSum = 0;
        while (number > 0){
            int check = number % 10;
            if (check % 2 != 0)
                oddSum += check;
            number /= 10;
        }
        return oddSum;
    }
}
