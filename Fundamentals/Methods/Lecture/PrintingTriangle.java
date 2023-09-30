import java.util.Scanner;

public class PrintingTriangle {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        trianglePrinter ( Integer.parseInt ( scan.nextLine () ) );
    }
    public static void linePrinter (int startNum, int endNum  ) {
        for ( int i = startNum ; i <= endNum  ; i++ ) {
            System.out.print ( i + " " );
        }
        System.out.println ( );
    }
    public static void trianglePrinter (int num){
        for ( int i = 0 ; i <= num ; i++ ) {
            linePrinter ( 1,i );
        }
        for ( int i = num - 1 ; i >=0  ; i-- ) {
            linePrinter ( 1,i );
        }
    }
}
