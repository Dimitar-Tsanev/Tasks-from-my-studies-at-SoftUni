import java.util.Scanner;

public class TheSquirrel {
    private static final Scanner scanner = new Scanner ( System.in );

    private static int collectedHazelNuts = 0;

    public static void main ( String[] args ) {

        int matrixDimensions = Integer.parseInt ( scanner.nextLine ( ) );

        String[] commands = getCommands();

        String[][] matrix = fillMatrix (matrixDimensions);

        int[] squirrelPosition = findCoordinates ( matrix );

        int row = squirrelPosition[0];
        int col = squirrelPosition[1];

        for ( String command: commands ){
            int [] nextCoordinates = findNextPosition ( command,row, col );

            int nextRow = nextCoordinates[0];
            int nextCol = nextCoordinates[1];

            if (!isStillInside ( nextRow,nextCol,matrix )){
                printScenario ( "out" );
                return;

            }
            String scenario = matrix[nextRow][nextCol];

            if ( scenario.equals ( "t" ) ){
                printScenario ( scenario );
                return;

            }
            if (scenario.equals ( "h" )){
                collectedHazelNuts++;
                matrix[nextRow][nextCol] = "*";

                if (collectedHazelNuts == 3){
                    printScenario ( "win" );
                    return;
                }
            }
            row = nextRow;
            col = nextCol;
        }
        printScenario ( "end" );
    }

    private static void printScenario ( String scenario) {
        switch (scenario){
            case "out":
                System.out.println ( "The squirrel is out of the field.");
                break;
            case "t":
                System.out.println ( "Unfortunately, the squirrel stepped on a trap...");
                break;
            case "win":
                System.out.println ( "Good job! You have collected all hazelnuts!");
                break;
            case "end":
                System.out.println ( "There are more hazelnuts to collect." );
                break;

        }
        System.out.println ( "Hazelnuts collected: " + collectedHazelNuts );
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
                if ( matrix[row][col].equals ( "s" ) ) {
                    coordinates[0] = row;
                    coordinates[1] = col;
                    break;
                }
            }
        }
        return coordinates;
    }
    private static String[] getCommands () {
        return scanner.nextLine ( ).split ( ", " );
    }

    private static String[][] fillMatrix ( int matrixDimensions ) {

        String[][] matrix = new String[matrixDimensions][matrixDimensions];

        for ( int row = 0 ; row < matrixDimensions ; row++ ) {
            matrix[row] = scanner.nextLine ( ).split ( "" );
        }
        return matrix;
    }

}
