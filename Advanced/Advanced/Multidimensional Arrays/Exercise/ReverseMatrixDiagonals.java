import java.util.Arrays;
import java.util.Scanner;

public class ReverseMatrixDiagonals {
    private static final Scanner scanner = new Scanner ( System.in );
    public static void main ( String[] args ) {
        int[] matrixDimensions = readArray ();
        
        int rows = matrixDimensions[0];
        int cols = matrixDimensions[1];
        
        int[][] matrix = fillMatrix ( rows,cols );

        int currentRow = rows - 1;
        int currentCol = cols - 1;
        int counter = 0;

        while (currentRow !=0 || currentCol != 0 || counter == 0){
            if (currentCol == 0 && counter == 1){
                currentRow--;

            }
            counter = currentCol == 0 ? 1 : 0;

            int previousCol = currentCol + 1;
            int previousRow = currentRow - 1;

            System.out.print ( matrix[currentRow][currentCol] + " " );

            while (previousCol < cols && previousRow >= 0){
                System.out.print ( matrix[previousRow][previousCol] + " " );
                previousRow--;
                previousCol++;

            }
            currentCol--;
            currentCol = Math.max ( 0, currentCol );
            System.out.println ( );

        }
    }
    private static int [][]fillMatrix ( int rows, int cols ) {
        int [][] matrix = new int [rows][cols];
        for ( int row = 0 ; row < rows ; row++ ) {
            matrix[row] = readArray ();

        }
        return matrix;
    }
    private static int[] readArray (){
        return Arrays.stream ( scanner.nextLine ( ).split ( "\\s+" ) )
                .mapToInt ( Integer::parseInt )
                .toArray ( );
    }
}
