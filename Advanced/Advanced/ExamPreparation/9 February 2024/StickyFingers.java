import java.util.Scanner;

public class StickyFingers {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        int matrixDimensions = Integer.parseInt ( scanner.nextLine ( ) );

        String[] movements = scanner.nextLine ().split ( "," );

        String[][] matrix = insertMatrix(matrixDimensions,scanner);

        int totalStolen = 0;

        int[] currentPosition = finDillinger(matrix);

        int row = currentPosition [0];
        int col = currentPosition [1];

        for ( String currentMove : movements ) {
            int nextCol = col;
            int nextRow = row;

            String scenario = "";

            switch (currentMove) {
                case "left":
                    nextCol--;
                    if ( isValidCoordinates ( matrix, nextRow, nextCol ) ) {
                        scenario = matrix[row][nextCol];
                    } else {
                        nextCol = col;
                        System.out.println ( "You cannot leave the town, there is police outside!" );
                    }
                    break;
                case "right":
                    nextCol++;
                    if ( isValidCoordinates ( matrix, nextRow, nextCol ) ) {
                        scenario = matrix[row][nextCol];

                    } else {
                        nextCol = col;
                        System.out.println ( "You cannot leave the town, there is police outside!" );
                    }
                    break;
                case "up":
                    nextRow--;
                    if ( isValidCoordinates ( matrix, nextRow, nextCol ) ) {
                        scenario = matrix[nextRow][col];
                    } else {
                        nextRow = row;
                        System.out.println ( "You cannot leave the town, there is police outside!" );
                    }
                    break;
                case "down":
                    nextRow++;
                    if ( isValidCoordinates ( matrix, nextRow, nextCol ) ) {
                        scenario = matrix[nextRow][col];
                    } else {
                        nextRow = row;
                        System.out.println ( "You cannot leave the town, there is police outside!" );
                    }
                    break;

            }
            matrix[row][col] = "+";

            if ( scenario.equals ( "P" ) ) {
                System.out.printf ( "You got caught with %d$, and you are going to jail.%n", totalStolen );
                matrix[nextRow][nextCol] = "#";
                printMatrix(matrix);
                return;

            } else if ( "$".equals ( scenario ) ) {
                int stolen = nextCol * nextRow;
                System.out.printf ( "You successfully stole %d$.%n", stolen );
                totalStolen += stolen;

            }
            matrix[nextRow][nextCol] = "D";

            row = nextRow;
            col = nextCol;
        }

        System.out.printf ("Your last theft has finished successfully with %d$ in your pocket.%n",totalStolen );
        printMatrix ( matrix );
    }

    private static void printMatrix ( String[][] matrix ) {
        for ( String[] line : matrix ) {
            System.out.println ( String.join ( " ", line ) );
        }
    }

    private static boolean isValidCoordinates ( String[][] matrix, int nextRow, int nextCol ) {
        return nextRow >= 0 && nextRow < matrix.length && nextCol >= 0 && nextCol < matrix.length;
    }

    private static int[] finDillinger ( String[][] matrix ) {
        int[] coordinates = new int[2];
        boolean stop = false;
        for ( int row = 0; row < matrix.length; row++){
            for (int col = 0; col < matrix[row].length; col++){
                if (matrix[row][col].equals ( "D" )){
                    coordinates [0] = row;
                    coordinates [1] = col;
                    stop = true;
                    break;
                }
            }
            if ( stop ){
                break;
            }
        }
        return coordinates;
    }

    private static String[][] insertMatrix ( int matrixDimensions, Scanner scanner) {
        String[][] matrix = new String[matrixDimensions][matrixDimensions];
        for ( int i = 0 ; i < matrixDimensions ; i++ ) {
            matrix[i] = scanner.nextLine ().split ( "\\s+" ) ;
        }
        return matrix;
    }

}
