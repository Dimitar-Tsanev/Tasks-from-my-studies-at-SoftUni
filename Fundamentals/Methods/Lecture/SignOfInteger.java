import java.util.Scanner;

public class SignOfInteger {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        signPrinter ( Integer.parseInt ( scan.nextLine () ) );
    }
    public static void signPrinter (int num){
        if (num > 0)
            System.out.printf ( "The number %d is positive.",num );
        else if ( num < 0 )
            System.out.printf ( "The number %d is negative.", num );
        else
            System.out.print ( "The number 0 is zero." );
    }
}
