import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        int[] matrixSize =  Arrays.stream( scanner.nextLine ().split ( "\\s+" ) )
                .mapToInt ( Integer::parseInt )
                .toArray ();

        int [][] matrix1 = new int[matrixSize[0]][matrixSize[1]];

        for ( int i = 0 ; i < matrixSize[0] ; i++ ) {
            int[] tokens = Arrays.stream( scanner.nextLine ().split ( "\\s+" ) )
                    .mapToInt ( Integer::parseInt )
                    .toArray ();

            matrix1 [i] = tokens;
        }

        matrixSize =  Arrays.stream( scanner.nextLine ().split ( "\\s+" ) )
                .mapToInt ( Integer::parseInt )
                .toArray ();

        int [][] matrix2 = new int[matrixSize[0]][matrixSize[1]];

        for ( int i = 0 ; i < matrixSize[0] ; i++ ) {
            int[] tokens = Arrays.stream( scanner.nextLine ().split ( "\\s+" ) )
                    .mapToInt ( Integer::parseInt )
                    .toArray ();

            matrix2 [i] = tokens;
        }

        String result = isMatrixEqual(matrix1,matrix2)? "equal":"not equal";

        System.out.println ( result );
    }

    private static boolean isMatrixEqual ( int[][] matrix1, int[][] matrix2 ) {
        if (matrix1.length != matrix2.length){
            return false;

        }
        for ( int i = 0 ; i < matrix1.length ; i++ ) {
            if ( matrix1[i].length != matrix2[i].length ){
                return false;
            }
            for ( int j = 0 ; j < matrix1[i].length ; j++ ) {
                if ( matrix1[i][j] != matrix2[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
