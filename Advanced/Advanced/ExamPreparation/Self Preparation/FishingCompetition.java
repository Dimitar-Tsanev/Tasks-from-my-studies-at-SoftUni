import java.util.Scanner;

public class FishingCompetition {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        String[][] matrix = fillMatrix ( scanner );

        int[] boatCoordinates = findCoordinates ( matrix );

        int quota = 20;
        int caught = 0;

        int row = boatCoordinates[0];
        int col = boatCoordinates[1];

        String command = scanner.nextLine ( );

        while (!"collect the nets".equals ( command )) {
            int[] nextCoordinates = findNextPosition ( command, row, col );

            matrix[row][col] = "-";

            int nextRow = nextCoordinates[0];
            int nextCol = nextCoordinates[1];

            if ( nextRow >= matrix.length ) {
                nextRow = 0;

            } else if ( nextRow < 0 ) {
                nextRow = matrix.length - 1;
            }

            if ( nextCol >= matrix[nextRow].length ) {
                nextCol = 0;

            } else if ( nextCol < 0 ) {
                nextCol = matrix[nextRow].length - 1;

            }
            String scenario = matrix[nextRow][nextCol];

            if ( scenario.equals ( "W" ) ) {
                System.out.printf ( "You fell into a whirlpool! " +
                        "The ship sank and you lost the fish you caught. " +
                        "Last coordinates of the ship: [%d,%d]%n", nextRow, nextCol );

                return;

            } else if ( scenario.matches ( "\\d" ) ) {
                caught += Integer.parseInt ( matrix[nextRow][nextCol] );

            }
            matrix[nextRow][nextCol] = "S";

            row = nextRow;
            col = nextCol;

            command = scanner.nextLine ( );
        }
        if ( caught >= quota ) {
            System.out.println ( "Success! You managed to reach the quota!" );

        } else {
            System.out.print ( "You didn't catch enough fish and didn't reach the quota! " );
            System.out.printf ( "You need %d tons of fish more.%n", quota - caught );

        }
        if ( caught > 0 ) {
            System.out.printf ( "Amount of fish caught: %d tons.%n", caught );

        }
        printMatrix ( matrix );

    }

    private static void printMatrix ( String[][] matrix ) {
        for ( String[] row : matrix ) {
            System.out.println ( String.join ( "", row ) );
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

    private static int[] findCoordinates ( String[][] matrix ) {
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

    private static String[][] fillMatrix ( Scanner scanner ) {
        int matrixDimensions = Integer.parseInt ( scanner.nextLine ( ) );

        String[][] matrix = new String[matrixDimensions][matrixDimensions];

        for ( int row = 0 ; row < matrixDimensions ; row++ ) {
            matrix[row] = scanner.nextLine ( ).split ( "" );
        }
        return matrix;
    }
}

