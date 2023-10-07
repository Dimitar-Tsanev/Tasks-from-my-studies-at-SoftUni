import java.util.Scanner;

public class AddAndSubtract {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        subtraction ( Integer.parseInt ( scan.nextLine ( ) ),
                Integer.parseInt ( scan.nextLine ( ) ),
                Integer.parseInt ( scan.nextLine ( ) ) );
    }

    public static void subtraction ( int num1, int num2, int num3 ) {
        int result = summing ( num1, num2 ) - num3;
        System.out.println ( result );
    }

    public static int summing ( int num1, int num2 ) {
        return num1 + num2;
    }
}
