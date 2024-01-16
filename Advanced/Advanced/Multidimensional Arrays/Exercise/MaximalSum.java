import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    private static final Scanner scanner = new Scanner ( System.in );

    public static void main ( String[] args ) {
        int[] matrixSize = getArray ( );

        int rows = matrixSize[0];
        int cols = matrixSize[1];

        int[][] matrix = new int[rows][cols];
        fillMatrix ( matrix );

        int maxSumOfSubMatrix = Integer.MIN_VALUE;
        int [] beggingPositionOfMaxSumSubMatrix = new int[2];

        for ( int row = 0 ; row < matrix.length - 2 ; row++ ) {
            for ( int col = 0 ; col < matrix[row].length - 2 ; col++ ) {
                int currentSum = 0;

                for ( int subMatrixRow = row ; subMatrixRow < row + 3 ; subMatrixRow++ ) {
                    for ( int subMatrixCol = col ; subMatrixCol < col + 3 ; subMatrixCol++ ) {
                        currentSum += matrix[subMatrixRow][subMatrixCol];
                    }
                }

                if (currentSum > maxSumOfSubMatrix){
                    maxSumOfSubMatrix = currentSum;

                    beggingPositionOfMaxSumSubMatrix[0] = row;
                    beggingPositionOfMaxSumSubMatrix[1] = col;

                }
            }
        }
        System.out.println ( "Sum = " + maxSumOfSubMatrix );

        printBestSubMatrix(matrix, beggingPositionOfMaxSumSubMatrix);

    }
    private static void printBestSubMatrix ( int[][] matrix, int[] beggingPositionOfMaxSumSubMatrix ) {
        int startRow = beggingPositionOfMaxSumSubMatrix[0];
        int startCol = beggingPositionOfMaxSumSubMatrix[1];

        for ( int row = startRow ; row < startRow + 3 ; row++ ) {
            for ( int col = startCol ; col < startCol + 3 ; col++ ) {
                System.out.print ( matrix[row][col] + " " );

            }
            System.out.println (  );
        }
    }

    private static void fillMatrix ( int[][] matrix ) {
        for ( int row = 0 ; row < matrix.length ; row++ ) {
            matrix[row] = getArray ( );

        }
    }
    private static int[] getArray () {
        return Arrays.stream ( scanner.nextLine ( ).split ( "\\s+" ) )
                .mapToInt ( Integer::parseInt )
                .toArray ( );

    }
}
