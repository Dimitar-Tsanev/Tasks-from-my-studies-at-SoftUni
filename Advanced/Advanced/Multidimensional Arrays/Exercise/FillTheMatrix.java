import java.util.Scanner;

public class FillTheMatrix {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );
        String[] sizeAndPattern = scanner.nextLine ( ).split ( ", " );

        int matrixSize = Integer.parseInt ( sizeAndPattern[0] );
        String pattern = sizeAndPattern[1];

        int[][] matrix = new int[matrixSize][matrixSize];

        switch (pattern) {
            case "A":
                fillMatrixPatternA ( matrix );
                break;
            case "B":
                fillMatrixPatternB ( matrix );
                break;
        }
        for ( int[] row : matrix ) {
            for ( int element : row ) {
                System.out.print ( element + " " );
            }
            System.out.println ( );
        }

    }

    public static void fillMatrixPatternA ( int[][] matrix ) {
        int currentNumber = 1;
        for ( int col = 0 ; col < matrix.length ; col++ ) {
            for ( int row = 0 ; row < matrix.length ; row++ ) {
                matrix[row][col] = currentNumber;
                currentNumber++;
            }
        }
    }

    public static void fillMatrixPatternB ( int[][] matrix ) {
        int currentNumber = 1;
        for ( int col = 0 ; col < matrix.length ; col++ ) {
            if ( col % 2 == 0 ) {
                for ( int row = 0 ; row < matrix.length ; row++ ) {
                    matrix[row][col] = currentNumber;
                    currentNumber++;
                }

            } else {
                for ( int row = matrix.length -1 ; row >= 0  ; row-- ) {
                    matrix[row][col] = currentNumber;
                    currentNumber++;
                }
            }
        }
    }
}
