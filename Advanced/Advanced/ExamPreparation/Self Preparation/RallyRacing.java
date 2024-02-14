import java.util.*;

public class RallyRacing {
    private static final Scanner scanner = new Scanner ( System.in );
    private static int passedDistance = 0;

    public static void main ( String[] args ) {
        String splitter = "\\s+";

        int[] matrixDimensions = getArray ( splitter );

        String carNumber = scanner.nextLine ( );

        String[][] matrix = fillMatrix ( matrixDimensions,splitter );

        int row = 0;
        int col = 0;

        matrix[row][col] = "C";

        String command = scanner.nextLine ();

        while (!"End".equals ( command )){
            int[] nextPosition = findNextPosition ( command,row,col );
            matrix[row][col] = ".";

            passedDistance += 10;

            String scenario = matrix[nextPosition[0]][nextPosition[1]];

            matrix[nextPosition[0]][nextPosition[1]] = "C";

            if ("F".equals ( scenario )){
                System.out.printf ( "Racing car %s finished the stage!%n",carNumber );

                printEnd ( matrix );
                return;

            }
            if ("T".equals ( scenario)){
                passedDistance += 20;

                matrix[nextPosition[0]][nextPosition[1]] = ".";
                nextPosition = findSymbol ( matrix, "T" );

            }
            row = nextPosition[0];
            col = nextPosition[1];

            command = scanner.nextLine ();

        }
        System.out.printf ( "Racing car %s DNF.%n", carNumber );
        printEnd ( matrix );
    }


    private static void printEnd ( String[][] matrix ) {
        System.out.printf ( "Distance covered %d km.%n", passedDistance );

        for ( String[] row : matrix ) {
            System.out.println ( Arrays.toString ( row )
                    .replaceAll ( "[\\[, \\]]", "" ) );
        }
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

    public static int[] getArray ( String splitter ) {
        return Arrays.stream ( scanner.nextLine ( ).split ( splitter ) )
                .mapToInt ( Integer::parseInt )
                .toArray ( );
    }

    private static String[][] fillMatrix ( int[] matrixDimensions,String splitter ) {
        String[][] matrix;

        if ( matrixDimensions.length > 1 ) {
            matrix = new String[matrixDimensions[0]][matrixDimensions[1]];

        }else {
            matrix = new String[matrixDimensions[0]][matrixDimensions[0]];

        }

        int counter = 0;

        while (counter < matrix.length){
            matrix[counter++] = scanner.nextLine ().split ( splitter );

        }
        return matrix;
    }
}


