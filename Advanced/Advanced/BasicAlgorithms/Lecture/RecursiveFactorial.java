import java.util.Scanner;

public class RecursiveFactorial {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        int num = Integer.parseInt ( scanner.nextLine () );

        System.out.println ( getFactorial(num) );
    }

    private static int getFactorial ( int num ) {
        if (num == 0 ){
            return 1;
        }
        return num * getFactorial ( num - 1 );
    }
}
