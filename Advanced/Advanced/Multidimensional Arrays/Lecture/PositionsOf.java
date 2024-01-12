import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        int[] matrixDimensions = Arrays.stream( scanner.nextLine ().split ( "\\s+" ) )
                .mapToInt ( Integer::parseInt )
                .toArray ();

        int rows = matrixDimensions[0];
        int columns = matrixDimensions[1];

        int [][] matrix = new int[rows][columns];

        for ( int i = 0 ; i < rows ; i++ ) {
            int[] rowColumns = Arrays.stream( scanner.nextLine ().split ( "\\s+" ) )
                    .mapToInt ( Integer::parseInt )
                    .toArray ();

            matrix[i] = rowColumns;

        }

        int num = Integer.parseInt ( scanner.nextLine ( ) );

        boolean isFound = false;

        for ( int i = 0 ; i < matrix.length ; i++ ) {
            for ( int j = 0 ; j < matrix[i].length ; j++ ) {
                if ( matrix [i][j] == num ){
                    System.out.println ( i + " " + j );
                    isFound = true;

                }
            }
        }
        if (!isFound){
            System.out.println ( "not found" );
        }
    }
}
