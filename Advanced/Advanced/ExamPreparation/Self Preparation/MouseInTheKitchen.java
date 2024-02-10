import java.util.Arrays;
import java.util.Scanner;

public class MouseInTheKitchen {
    private static final Scanner scanner = new Scanner ( System.in );

    private static int cheeseCount = 0;

    public static void main ( String[] args ) {

        String[][] matrix = fillMatrix ();

        int[] mousePosition = findCoordinates ( matrix );
        int mouseRow = mousePosition[0];
        int mouseCol = mousePosition[1];

        String command = scanner.nextLine ();

        while (!"danger".equals ( command )){
            int[] nextCoordinates = findNextPosition ( command,mouseRow,mouseCol );

            int nextRow = nextCoordinates[0];
            int nextCol = nextCoordinates[1];

            if (!isStillInside ( nextRow,nextCol,matrix )){
                System.out.println ("No more cheese for tonight!" );
                printMatrix ( matrix );
                return;

            }
            String scenario = matrix[nextRow][nextCol];

            if (scenario.equals ( "@" )){
                command = scanner.nextLine ();
                continue;

            }
            matrix[mouseRow][mouseCol] = "*";
            matrix[nextRow][nextCol] = "M";

            if ( scenario.equals ( "T" ) ){
                System.out.println ("Mouse is trapped!" );
                printMatrix ( matrix );
                return;

            }
            if (scenario.equals ( "C" )){
                cheeseCount--;
                if (cheeseCount == 0){
                    System.out.println ("Happy mouse! All the cheese is eaten, good night!" );
                    printMatrix ( matrix );
                    return;

                }
            }
            mouseRow = nextRow;
            mouseCol = nextCol;

            command = scanner.nextLine ();
        }
        System.out.println ( "Mouse will come back later!" );
        printMatrix ( matrix );

    }
    private static void printMatrix ( String[][] matrix ) {
        for ( String[] row : matrix ) {
            System.out.println (Arrays.toString ( row )
                    .replaceAll ( "[\\[, \\]]","" ));
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

    private static int[] findCoordinates ( String[][] matrix ) {
        int[] coordinates = new int[2];
        for ( int row = 0 ; row < matrix.length ; row++ ) {
            for ( int col = 0 ; col < matrix[row].length ; col++ ) {
                if ( matrix[row][col].equals ( "M" ) ) {
                    coordinates[0] = row;
                    coordinates[1] = col;

                } else if ( matrix[row][col].equals ( "C" ) ) {
                    cheeseCount++;
                }
            }
        }
        return coordinates;
    }

    private static String[][] fillMatrix ( ) {
        int[] matrixDimensions = Arrays.stream ( scanner.nextLine ().split ( "," ) )
                .mapToInt ( Integer::parseInt )
                .toArray ();

        String[][] matrix = new String[matrixDimensions[0]][matrixDimensions[1]];

        for ( int row = 0 ; row < matrix.length ; row++ ) {
            matrix[row] = scanner.nextLine ( ).split ( "" );
        }
        return matrix;
    }

}
