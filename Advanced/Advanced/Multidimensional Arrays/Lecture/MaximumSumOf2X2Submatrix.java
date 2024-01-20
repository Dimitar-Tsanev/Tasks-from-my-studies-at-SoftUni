import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2X2Submatrix {
    private static final Scanner scanner = new Scanner ( System.in );

    public static void main ( String[] args ) {

        int[] matrixDimensions = getArray ();

        int rows = matrixDimensions[0];
        int cols = matrixDimensions[1];

        int[][] matrix = fillMatrix ( rows,cols );

        int bestStartRow = 0;
        int bestStartCol = 0;
        int bestSum = Integer.MIN_VALUE;

        for ( int row = 0 ; row < matrix.length - 1  ; row++ ) {
            for (int col = 0; col < matrix[row].length - 1; col++){
                int sum = matrix[row][col] + matrix[row][col + 1] +
                        matrix[row + 1][col] + matrix[row + 1][col + 1];

                if (bestSum < sum) {
                    bestStartRow = row;
                    bestStartCol = col;
                    bestSum = sum;

                }
            }
        }
        System.out.println ( matrix[bestStartRow][bestStartCol] +
                " " + matrix[bestStartRow][bestStartCol + 1] );
        System.out.println ( matrix[bestStartRow + 1][bestStartCol] +
                " " + matrix[bestStartRow + 1][bestStartCol + 1] );
        System.out.println ( bestSum );

    }
    private static int[][] fillMatrix ( int rows,int cols ) {
        int[][] matrix = new int[rows][cols];
        for ( int row = 0 ; row < matrix.length ; row++ ) {
            matrix[row] = getArray ( );

        }
        return matrix;
    }
    private static int[] getArray () {
        return Arrays.stream ( scanner.nextLine ( ).split ( ", " ) )
                .mapToInt ( Integer::parseInt )
                .toArray ( );

    }
}
