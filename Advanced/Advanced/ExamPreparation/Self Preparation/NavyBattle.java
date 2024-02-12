import java.util.Arrays;
import java.util.Scanner;

public class NavyBattle {
    private static final Scanner scanner = new Scanner ( System.in );
    private static String [][] matrix = fillMatrix (  );

    public static void main ( String[] args ) {
        int[] position = findCoordinates ();

        int row = position[0];
        int col = position[1];

        int cruiserDestroyed = 0;
        int mineHits = 0;

        while (cruiserDestroyed < 3 && mineHits < 3){
            String command = scanner.nextLine ();
            matrix[row][col] = "-";

            position = findNextPosition (command ,row,col );

            int nextRow = position[0];
            int nextCol = position[1];

            String scenario = matrix[nextRow][nextCol];
            matrix[nextRow][nextCol] = "S";

            if("*".equals ( scenario )){
                mineHits++;

            } else if ( "C".equals ( scenario ) ) {
                cruiserDestroyed++;

            }

            row = nextRow;
            col = nextCol;
        }
        String win = "Mission accomplished, " +
                "U-9 has destroyed all battle cruisers of the enemy!";

        String lose = String.format ( "Mission failed, " +
                "U-9 disappeared! Last known coordinates [%d, %d]!",
                row,
                col);

        System.out.println ( cruiserDestroyed == 3? win:lose );

        printMatrix ();

    }

    private static void printMatrix (  ) {
        for ( String[] row : matrix ) {
            System.out.println ( Arrays.toString ( row )
                    .replaceAll ( "[\\[, \\]]","" ));
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

    private static int[] findCoordinates ( ) {
        int[] coordinates = new int[2];
        for ( int row = 0 ; row < matrix.length ; row++ ) {
            for ( int col = 0 ; col < matrix[row].length ; col++ ) {
                if ( matrix[row][col].equals ( "S" ) ) {
                    coordinates[0] = row;
                    coordinates[1] = col;
                    break;
                }
            }
        }
        return coordinates;
    }

    private static String[][] fillMatrix ( ) {
        int matrixDimensions = Integer.parseInt ( scanner.nextLine ( ) );

        String[][] matrix = new String[matrixDimensions][matrixDimensions];

        for ( int row = 0 ; row < matrixDimensions ; row++ ) {
            matrix[row] = scanner.nextLine ( ).split ( "" );
        }
        return matrix;
    }
}
