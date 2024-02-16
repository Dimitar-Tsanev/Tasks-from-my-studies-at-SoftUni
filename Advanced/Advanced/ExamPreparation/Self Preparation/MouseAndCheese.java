import java.util.*;

public class MouseAndCheese {
    private static final Scanner scanner = new Scanner ( System.in );
    public static void main ( String[] args ) {
        String splitter = "";

        int[] matrixDimensions = getArray ( splitter );

        String[][] matrix = fillMatrix ( matrixDimensions, splitter );

        int[] position = findSymbol ( matrix, "M" );

        int row = position[0];
        int col = position[1];

        int eatenCheese = 0;
        boolean mouseOut = false;

        String command = scanner.nextLine ();

        while ( !"end".equals ( command)) {
            int[] nextPosition = findNextPosition ( command, row, col );

            int nextRow = nextPosition[0];
            int nextCol = nextPosition[1];

            matrix[row][col] = "-";

            if (!isStillInside (nextRow,nextCol,matrix  )){
                mouseOut = true;
                break;

            }
            String scenario = matrix[nextRow][nextCol];
            if ( scenario.equals ( "B" ) ) {
                matrix[nextRow][nextCol] = "-";
                nextPosition = findNextPosition ( command, nextRow, nextCol);

                nextRow = nextPosition[0];
                nextCol = nextPosition[1];
                scenario = matrix[nextRow][nextCol];

            }
            if (scenario.equals ( "c" )){
                eatenCheese++;

            }
            row = nextRow;
            col = nextCol;
            matrix[row][col] = "M";

            command = scanner.nextLine ();
        }
        if (mouseOut){
            System.out.println ("Where is the mouse?" );

        }
        String win = String.format ( "Great job, the mouse is fed %d cheeses!",eatenCheese );
        String lose = String.format ( "The mouse couldn't eat the cheeses, she needed %d cheeses more.", 5 - eatenCheese );

        System.out.println ( eatenCheese >= 5 ? win : lose );

        printMatrix ( matrix );
    }

    private static void printMatrix ( String[][] matrix ) {
        for ( String[] row : matrix ) {
            System.out.println ( Arrays.toString ( row )
                    .replaceAll ( "[\\[, \\]]", "" ) );
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
