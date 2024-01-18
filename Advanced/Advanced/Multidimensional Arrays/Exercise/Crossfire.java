import java.util.*;

public class Crossfire {
    private static int rows;
    private static int cols;

    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        int[] matrixDimensions = Arrays.stream ( scanner.nextLine ( ).split ( "\\s+" ) )
                .mapToInt ( Integer::parseInt )
                .toArray ( );

        rows = matrixDimensions[0];
        cols = matrixDimensions[1];

        List<List<Integer>> matrix = fillMatrix ( );

        String command = scanner.nextLine ( );

        while (!"Nuke it from orbit".equals ( command )) {
            int[] commandParameters = Arrays.stream ( command.split ( "\\s+" ) )
                    .mapToInt ( Integer::parseInt )
                    .toArray ( );

            int blastAtRow = commandParameters[0];
            int blastAtCol = commandParameters[1];
            int blastPower = commandParameters[2];

            int startRow = blastAtRow - blastPower;
            int stopRow = blastAtRow + blastPower;

            int startCol = blastAtCol - blastPower;
            int stopCol = blastAtCol + blastPower;

            for ( int currentColumn = startCol ; currentColumn <= stopCol ; currentColumn++ ) {
                if ( isInMatrix ( blastAtRow, currentColumn, matrix ) ) {
                    matrix.get ( blastAtRow ).set (currentColumn, 0 );

                }
            }

            for ( int currentRow = startRow ; currentRow <= stopRow ; currentRow++ ) {
                if ( isInMatrix ( currentRow, blastAtCol, matrix ) ) {
                    matrix.get ( currentRow ).set ( blastAtCol,0 );

                }
            }
            for ( int row = 0; row < matrix.size (); row++ ) {
                for ( int col = matrix.get (row).size ( ) - 1 ; col >= 0 ; col-- ) {
                    if ( matrix.get(row).get ( col ) == 0 ) {
                        matrix.get ( row ).remove ( col );
                    }
                }
            }

            matrix.removeIf ( List::isEmpty );

            command = scanner.nextLine ( );

        }
        printMatrix ( matrix );
    }

    private static boolean isInMatrix ( int blastAtRow, int blastAtCol, List<List<Integer>> matrix ) {
        return blastAtRow >= 0 && blastAtRow < matrix.size ( ) && blastAtCol >= 0 && blastAtCol < matrix.get ( blastAtRow ).size ( );
    }

    private static void printMatrix ( List<List<Integer>> matrix ) {
        for ( List<Integer> row : matrix ) {
            row.forEach ( v -> System.out.print ( v + " " ) );
            System.out.println ( );
        }
    }

    private static List<List<Integer>> fillMatrix () {
        List<List<Integer>> matrix = new ArrayList<> ( );
        int counter = 1;
        for ( int row = 0 ; row < rows ; row++ ) {
            matrix.add ( new ArrayList<> ( ) );
            for ( int col = 0 ; col < cols ; col++ ) {
                matrix.get ( row ).add ( counter );
                counter++;
            }
        }
        return matrix;
    }
}
