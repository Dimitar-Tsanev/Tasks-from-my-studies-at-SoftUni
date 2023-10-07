import java.util.Scanner;

public class NxNMatrix {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        int number = Integer.parseInt ( scan.nextLine ( ) );
        matrixPrinter ( number );
    }
    public static void matrixPrinter (int num){
        for ( int i = 0 ; i < num ; i++ ) {
            System.out.println ( getRow ( num ) );
        }
    }
    public static String getRow (int num){
        StringBuilder result = new StringBuilder ( );
        for ( int i = 0 ; i < num ; i++ ) {
            result.append ( num ).append ( " " );
        }
        return result.toString ( );
    }
}
