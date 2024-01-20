import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    private static final Scanner scanner = new Scanner ( System.in );
    public static void main ( String[] args ) {
        int matrixDimensions = Integer.parseInt ( scanner.nextLine ( ) );

        Queue <Integer> topLeftBottomRightDiagonal = new ArrayDeque<> (  );
        Queue <Integer> bottomLeftTopRightDiagonal = new ArrayDeque<> (  );


        int[][] matrix = new int[matrixDimensions][matrixDimensions];
        fillMatrix ( matrix );

        for ( int i = 0; i <matrix.length; i++ ){
            topLeftBottomRightDiagonal.offer ( matrix[i][i] );
            bottomLeftTopRightDiagonal.offer ( matrix[matrix.length - 1 - i][i] );
        }
        topLeftBottomRightDiagonal.forEach ( p -> System.out.print ( topLeftBottomRightDiagonal.poll () + " ") );
        System.out.println ( );
        bottomLeftTopRightDiagonal.forEach ( p -> System.out.print ( bottomLeftTopRightDiagonal.poll () + " ") );
        System.out.println ( );

    }
    private static void fillMatrix (int[][] matrix) {
        for ( int row = 0; row < matrix.length; row++ ) {
            matrix [row] = Arrays.stream ( scanner.nextLine ( ).split ( " " ) )
                    .mapToInt ( Integer::parseInt )
                    .toArray ( );
        }
    }
}
