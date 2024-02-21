import java.util.Scanner;

public class RhombusOfStars {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );
        
        int size = Integer.parseInt ( scanner.nextLine () );

        for ( int rowAscending = 1 ;  rowAscending <= size  ;  rowAscending++ ) {
            printRow( rowAscending, size);
        }
        for ( int rowDescending = size - 1 ; rowDescending >= 1  ; rowDescending-- ) {
            printRow ( rowDescending, size );
        }
    }

    private static void printRow ( int rowNumber, int size ) {
        System.out.println ( buildRow (rowNumber, size) );
    }
    private static String buildRow(int rowNumber, int size ){
        StringBuilder row = new StringBuilder ( );

        row.append ( " ".repeat ( Math.max ( 0, size - rowNumber ) ) );

        for ( int element = 1 ; element <= rowNumber * 2 ; element++ ) {
            if (element % 2 == 0){
                row.append (" ");

            }else{
                row.append ( "*" );

            }
        }
        return row.toString ();
    }
}
