import java.util.*;

public class TreasureHunt {
    private static final Scanner scanner = new Scanner ( System.in );

    public static void main ( String[] args ) {
        String splitter = "\\s+";

        int[] matrixDimensions = getArray ( splitter );

        String[][] matrix = fillMatrix ( matrixDimensions, splitter );

        int[] position = findSymbol ( matrix, "Y" );

        int row = position[0];
        int col = position[1];

        List<String> commands = getCommands ( "Finish" );
        List<String> rightMoves = new ArrayList<> ();

        String scenario = matrix[row][col];

        for ( String command : commands ) {
            int[] nextPosition = findNextPosition ( command, row, col );

            int nextRow = nextPosition[0];
            int nextCol = nextPosition[1];

            if ( !isStillInside ( nextRow, nextCol, matrix ) ) {
                continue;

            }
            scenario = matrix[nextRow][nextCol];

            if ( !scenario.equals ( "T" ) ) {
                row = nextRow;
                col = nextCol;
                rightMoves.add ( command );
            }
        }
        printEnd ( scenario, rightMoves );

    }

    private static void printEnd ( String scenario, List<String> commands ) {
        if(scenario.equals ( "X" )) {
            System.out.println ( "I've found the treasure!" );
            System.out.print ( "The right path is " + String.join ( ", ", commands ) );

        }else {
            System.out.println ( "The map is fake!");

        }
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

    private static List<String> getCommands ( String stopCondition ) {
        List<String> commands = new ArrayList<> ( );
        String command = scanner.nextLine ( );

        while (!stopCondition.equals ( command )) {
            commands.add ( command );
            command = scanner.nextLine ( );
        }
        return commands;
    }

    private static int[] findSymbol ( String[][] matrix, String symbol ) {
        int[] coordinates = new int[2];
        for ( int row = 0 ; row < matrix.length ; row++ ) {
            for ( int col = 0 ; col < matrix[row].length ; col++ ) {
                if ( matrix[row][col].equals ( symbol ) ) {
                    coordinates[0] = row;
                    coordinates[1] = col;
                    break;
                }
            }
        }
        return coordinates;
    }

    private static int[] getArray ( String splitter ) {
        return Arrays.stream ( scanner.nextLine ( ).split ( splitter ) )
                .mapToInt ( Integer::parseInt )
                .toArray ( );
    }

    private static String[][] fillMatrix ( int[] matrixDimensions, String splitter ) {
        String[][] matrix;

        if ( matrixDimensions.length > 1 ) {
            matrix = new String[matrixDimensions[0]][matrixDimensions[1]];

        } else {
            matrix = new String[matrixDimensions[0]][matrixDimensions[0]];

        }

        int counter = 0;

        while (counter < matrix.length) {
            matrix[counter++] = scanner.nextLine ( ).split ( splitter );

        }
        return matrix;
    }
}
