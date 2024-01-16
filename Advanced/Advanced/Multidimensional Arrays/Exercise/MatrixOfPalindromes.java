import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        int[] dimensions = Arrays.stream ( scanner.nextLine ().split ( "\\s+" ) )
                .mapToInt ( Integer::parseInt )
                .toArray ();

        int rows = dimensions[0];
        int cols = dimensions[1];

        String[][] matrix = new String[rows][cols];

        for ( int row = 0 ; row < matrix.length ; row++ ) {
            int startAndEnd =  97 + row;
            for ( int col = 0 ; col < matrix[row].length ; col++ ) {
                int middle = startAndEnd + col;

                System.out.printf ( "%c%c%c ",startAndEnd,middle,startAndEnd );

            }
            System.out.println ( );
        }
    }
}
