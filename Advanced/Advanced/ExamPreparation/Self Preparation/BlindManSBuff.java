import java.util.*;

public class BlindManSBuff {
    private static final Scanner scanner = new Scanner ( System.in );

    public static void main ( String[] args ) {
        String[][] matrix = fillMatrix ( );

        int[] position = findCoordinates ( matrix );

        int row = position[0];
        int col = position[1];

        int movesCounter = 0;
        int caughtPlayers = 0;

        String command = scanner.nextLine ( );

        while (!"Finish".equals ( command )) {
            int[] nextPosition = findNextPosition ( command, row, col );

            int nextRow = nextPosition[0];
            int nextCol = nextPosition[1];

            if ( isStillInside ( nextRow, nextCol, matrix ) ) {
                String scenario = matrix[nextRow][nextCol];

                if ( !scenario.equals ( "O" ) ) {
                    movesCounter++;

                    if ( scenario.equals ( "P" ) ) {
                        matrix[nextRow][nextCol] = "_";
                        caughtPlayers++;

                        if (caughtPlayers == 3){
                            break;
                        }
                    }

                    row = nextRow;
                    col = nextCol;
                }
            }

            command = scanner.nextLine ( );
        }
        System.out.println ( "Game over!" );
        System.out.printf ( "Touched opponents: %d Moves made: %d%n", caughtPlayers, movesCounter);

    }

    private static boolean isStillInside ( int row, int col, String[][] matrix ) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static int[] findNextPosition ( String command, int row, int col ) {
        switch (command) {
            case "up":
                row--;
                break;
            case "down":
                row++;
                break;
            case "left":
                col--;
                break;
            case "right":
                col++;
                break;
        }
        return new int[]{row, col};
    }

    private static int[] findCoordinates ( String[][] matrix ) {
        int[] coordinates = new int[2];
        for ( int row = 0 ; row < matrix.length ; row++ ) {
            for ( int col = 0 ; col < matrix[row].length ; col++ ) {
                if ( matrix[row][col].equals ( "B" ) ) {
                    coordinates[0] = row;
                    coordinates[1] = col;
                    break;
                }
            }
        }
        return coordinates;
    }

    private static String[][] fillMatrix () {
        int[] matrixDimensions = Arrays.stream ( scanner.nextLine ( ).split ( "\\s+" ) )
                .mapToInt ( Integer::parseInt )
                .toArray ( );

        String[][] matrix = new String[matrixDimensions[0]][matrixDimensions[1]];

        for ( int row = 0 ; row < matrix.length ; row++ ) {
            matrix[row] = scanner.nextLine ( ).split ( "\\s+" );
        }
        return matrix;
    }

}
