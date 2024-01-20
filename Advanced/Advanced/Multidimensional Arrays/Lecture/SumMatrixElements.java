import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    private static final Scanner scanner = new Scanner ( System.in );
    public static void main ( String[] args ) {


        int[] matrixDimensions = getArray ();

        int rows = matrixDimensions[0];
        int cols = matrixDimensions[1];

        int[][] matrix = getMatrix ( rows,cols );

        int sum = sumMatrixElements ( matrix );

        System.out.printf ( "%d%n%d%n%d%n",rows,cols,sum);


    }
    private static int sumMatrixElements (int[][] matrix){
        int matrixSum = 0;
        for ( int[] row: matrix ){
            matrixSum += Arrays.stream ( row ).sum ();
        }
        return matrixSum;
    }
    private static int[][] getMatrix(int rows,int cols){
        int[][] matrix = new int[rows][cols];
        for ( int row = 0 ; row < matrix.length ; row++ ) {
            matrix[row] = getArray ( );

        }
        return matrix;
    }
    private static int[] getArray(){
        return Arrays.stream ( scanner.nextLine ().split ( ", " ) )
                .mapToInt ( Integer::parseInt )
                .toArray ();
    }
}
