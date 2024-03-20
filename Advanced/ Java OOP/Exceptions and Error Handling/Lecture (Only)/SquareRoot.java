import java.text.DecimalFormat;
import java.util.Scanner;

public class SquareRoot {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        String input = scanner.nextLine ();

        try {
            int number = Integer.parseInt ( input );
            printSquareRoot ( number );

        }catch (IllegalArgumentException e){
            System.out.println ( "Invalid" );

        }finally {
            System.out.println ( "Goodbye" );

        }
    }
    private static void printSquareRoot (int number) throws IllegalArgumentException{
        if (number <= 0 ){
            throw new IllegalArgumentException ( );

        }
        System.out.println ( new DecimalFormat ( "0.00" ).format (  Math.sqrt ( number )) );
    }
}
