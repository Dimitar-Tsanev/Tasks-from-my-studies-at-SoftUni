import java.util.Arrays;
import java.util.Scanner;

public class DeliveryBoy {
    private static final Scanner scanner = new Scanner ( System.in );

    public static void main ( String[] args ) {
        String[][] matrix = fillMatrix ();

        int[] deliveryBoyStartCoordinates = findCoordinates ( matrix );

        int row = deliveryBoyStartCoordinates[0];
        int col = deliveryBoyStartCoordinates[1];

        boolean delivered = false;

        while (!delivered){
            String command = scanner.nextLine ( );

            int[] nextCoordinates = findNextPosition ( command, row, col );

            int nextRow = nextCoordinates[0];
            int nextCol = nextCoordinates[1];

            if (!isStillInside ( nextRow,nextCol, matrix)){
                System.out.println ("The delivery is late. Order is canceled." );

                matrix[deliveryBoyStartCoordinates[0]][deliveryBoyStartCoordinates[1]] = " ";

                break;

            }
            String scenario = matrix[nextRow][nextCol];

            if (scenario.equals ( "*" ) || scenario.equals ( "R" )){
                continue;

            }
            if (scenario.equals ( "P" )){
                matrix[nextRow][nextCol] = "R";

                System.out.println ("Pizza is collected. 10 minutes for delivery.");

            }
            if (scenario.equals ( "A" )){
                matrix[nextRow][nextCol] = "P";

                matrix[deliveryBoyStartCoordinates[0]][deliveryBoyStartCoordinates[1]] = "B";

                delivered = true;

                System.out.println ( "Pizza is delivered on time! Next order..." );

                continue;

            }
            if (scenario.equals ( "-" )){
                matrix [nextRow][nextCol] = ".";

            }
            row = nextRow;
            col = nextCol;

        }
        printMatrix ( matrix );
    }
    private static void printMatrix ( String[][] matrix ) {
        for ( String[] row : matrix ) {
            System.out.println ( String.join ( "", row ) );
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
                if ( matrix[row][col].equals ( "B" ) ) {
                    coordinates[0] = row;
                    coordinates[1] = col;
                    break;
                }
            }
        }
        return coordinates;
    }

    private static String[][] fillMatrix (  ) {
        int[] matrixDimensions = Arrays.stream ( scanner.nextLine ().split ( "\\s+" ) )
                .mapToInt ( Integer::parseInt )
                .toArray ();

        String[][] matrix = new String[matrixDimensions[0]][matrixDimensions[1]];

        for ( int row = 0 ; row < matrix.length ; row++ ) {
            matrix[row] = scanner.nextLine ( ).split ( "" );
        }
        return matrix;
    }

}
