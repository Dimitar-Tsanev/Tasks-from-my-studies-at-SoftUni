import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    private static final Scanner scanner = new Scanner ( System.in );
    public static void main ( String[] args ) {
        int[] matrixSize = getArray ( );

        int rows = matrixSize[0];
        int cols = matrixSize[1];

        String[][] matrix = new String[rows][cols];
        fillMatrix ( matrix );

        String commandArgs = scanner.nextLine ();

        while (!"END".equals ( commandArgs ) ){

            if (!checkIfCommandIsValid(commandArgs, matrix) ){
                System.out.println ( "Invalid input!" );
                commandArgs = scanner.nextLine ();
                continue;
            }
            String [] commandLine = commandArgs.split ( "\\s+" );

            int firstElementRow = Integer.parseInt ( commandLine[1] );
            int firstElementCol = Integer.parseInt ( commandLine[2] );
            int secondElementRow = Integer.parseInt ( commandLine[3] );
            int secondElementCol = Integer.parseInt ( commandLine[4] );

            String firstElement = matrix[firstElementRow][firstElementCol];
            matrix[firstElementRow][firstElementCol] = matrix[secondElementRow][secondElementCol];
            matrix[secondElementRow][secondElementCol] = firstElement;

            for ( String[] row: matrix ){
                System.out.println ( String.join ( " ",row ) );
            }

            commandArgs = scanner.nextLine ( );
        }
    }

    private static boolean checkIfCommandIsValid ( String commandArgs, String[][] matrix ) {
        String [] commandLine = commandArgs.split ( "\\s+" );

        String command = commandLine[0];

        if (commandLine.length != 5){
            return false;

        }else if (!"swap".equals ( command )){
            return false;

        }
        int firstElementRow = Integer.parseInt ( commandLine[1] );
        int firstElementCol = Integer.parseInt ( commandLine[2] );
        int secondElementRow = Integer.parseInt ( commandLine[3] );
        int secondElementCol = Integer.parseInt ( commandLine[4] );

        if (firstElementRow < 0 || firstElementRow > matrix.length - 1){
            return false;

        }
        if ( firstElementCol < 0 || firstElementCol > matrix[firstElementRow].length ) {
            return false;

        }
        if (secondElementRow < 0 || secondElementRow > matrix.length - 1){
            return false;

        }
        return secondElementCol >= 0 && secondElementCol <= matrix[secondElementRow].length;
    }

    private static void fillMatrix ( String[][] matrix ) {
        for ( int row = 0 ; row < matrix.length ; row++ ) {
            matrix[row] = scanner.nextLine ( ).split ( "\\s+" );

        }
    }
    private static int[] getArray () {
        return Arrays.stream ( scanner.nextLine ( ).split ( "\\s+" ) )
                .mapToInt ( Integer::parseInt )
                .toArray ( );

    }
}

