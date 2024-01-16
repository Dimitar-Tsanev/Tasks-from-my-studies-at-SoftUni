import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    private static final Scanner scanner = new Scanner ( System.in );

    public static void main ( String[] args ) {
        int matrixSize = Integer.parseInt ( scanner.nextLine ( ) );

        int[][] matrix = new int[matrixSize][matrixSize];
        fillMatrix ( matrix );

        System.out.println ( diagonalsSumDifference ( matrix ) );

    }

    private static void fillMatrix ( int[][] matrix ) {
        for ( int row = 0 ; row < matrix.length ; row++ ) {
            matrix[row] = Arrays.stream ( scanner.nextLine ( ).split ( "\\s+" ) )
                    .mapToInt ( Integer::parseInt )
                    .toArray ( );
        }
    }

    private static int diagonalsSumDifference ( int[][] matrix ) {
        int sumOfTopLeftBottomRightDiagonal = 0;
        int sumOfBottomLeftTopRightDiagonal = 0;

        for ( int i = 0 ; i < matrix.length ; i++ ) {
            sumOfTopLeftBottomRightDiagonal += matrix[i][i];
            sumOfBottomLeftTopRightDiagonal += matrix[matrix.length - 1 - i][i];

        }
        return Math.abs ( sumOfBottomLeftTopRightDiagonal - sumOfTopLeftBottomRightDiagonal );

    }
}
