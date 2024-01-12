import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        int rows = Integer.parseInt ( scanner.nextLine ());
        int columns = Integer.parseInt ( scanner.nextLine () );

        char[][] matrix1 = fillMatrix ( scanner,rows );
        char[][] matrix2 = fillMatrix ( scanner,rows );
        char[][] matrixResult = fillMatrixResult ( matrix1,matrix2,rows,columns );

        for ( char[] chars : matrixResult ) {
            for ( char aChar : chars ) {
                System.out.print ( aChar + " " );
            }
            System.out.println ( );
        }
    }
    private static char[][] fillMatrix (Scanner scanner, int rows){
        char [][] matrix = new char[rows][];
        for ( int i = 0 ; i < rows ; i++ ) {
            String rowData = scanner.nextLine ().replaceAll ( "\\s+","" );
            char[] rowColumns = rowData.toCharArray ();

            matrix [i] = rowColumns;
        }
        return matrix;
    }
    private static char[][] fillMatrixResult ( char[][] matrix1, char[][] matrix2, int rows, int columns){
        char [][] matrix = new char[rows][columns];
        for ( int i = 0 ; i < matrix1.length ; i++ ) {
            for ( int j = 0 ; j < matrix1[i].length ; j++ ) {
                if (matrix1[i][j] == matrix2[i][j]){
                    matrix [i][j] = matrix1[i][j];

                }else{
                    matrix[i][j] = '*';
                }
            }
        }
        return matrix;
    }
}
