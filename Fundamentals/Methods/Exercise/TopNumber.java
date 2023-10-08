import java.util.Scanner;

public class TopNumber {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        int num = Integer.parseInt ( scan.nextLine () );

        for ( int i = 1 ; i <= num  ; i++ ) {
            if (checksForOddDigitInNumber ( i ) && checksIfSumDivisibleBy8 ( i )){
                System.out.println ( i );
            }
        }
    }
    public static boolean checksIfSumDivisibleBy8(int currentNum){
        int sum = 0;

        while (currentNum > 0){
            sum += currentNum % 10;
            currentNum /=10;
        }
        return sum % 8 == 0;
    }
    public static boolean checksForOddDigitInNumber (int currentNum){

        while (currentNum > 0){
            int lastDigit = currentNum % 10;

            if (lastDigit % 2 != 0){
                return true;
            }else{
                currentNum /= 10;
            }
        }
        return false;
    }
}
