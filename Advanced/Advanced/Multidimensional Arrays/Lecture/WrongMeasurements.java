import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    private static final Scanner scanner = new Scanner ( System.in );
    public static void main ( String[] args ) {
        int rows = Integer.parseInt ( scanner.nextLine ( ) );

        int[][] matrix = new int[rows][];
        fillMatrix ( matrix );

        int[] coordinates = getArray ();

        int elementToReplace = matrix[coordinates[0]][coordinates[1]];

        int [][] resultMatrix = getResultMatrix ( matrix,elementToReplace );

        printMatrix ( resultMatrix );

    }
    private static void printMatrix(int [][] matrix){
        for ( int [] row : matrix ) {
            for ( int digit : row ) {
                System.out.print ( digit + " " );
            }
            System.out.println ( );
        }
    }
    private static int [][] getResultMatrix(int[][] matrix,int elementToReplace ){
        int rows = matrix.length;
        int cols = matrix[rows -1 ].length;

        int [][] resultMatrix = new int[rows][cols];

        for ( int row = 0 ; row < rows ; row++ ) {
            for ( int col = 0 ; col < cols ; col++ ) {
                if (matrix[row][col] != elementToReplace){
                    resultMatrix[row][col] = matrix[row][col];
                    continue;
                }
                int up = (row - 1 >= 0 ) ? (matrix[row - 1][col] != elementToReplace)? matrix[row - 1][col] : 0 : 0;
                int down = (row + 1 < matrix.length  ) ? (matrix[row + 1][col] != elementToReplace)? matrix[row + 1][col] : 0 : 0;
                int left = (col - 1 >= 0) ? (matrix[row][col - 1] != elementToReplace)? matrix[row][col - 1] : 0 : 0;
                int right = (col + 1 < matrix[row].length  ) ? (matrix[row][col + 1] != elementToReplace)? matrix[row][col + 1] : 0 : 0;

                resultMatrix[row][col] = up + down + left + right;
            }
        }
        return resultMatrix;
    }

    private static void fillMatrix (int[][] matrix) {
        for ( int row = 0; row < matrix.length; row++ ) {
            matrix [row] = getArray ();
        }
    }
    private static int[] getArray(){
        return Arrays.stream ( scanner.nextLine ().split ( "\\s+" ) )
                .mapToInt ( Integer::parseInt )
                .toArray ();
    }
}
