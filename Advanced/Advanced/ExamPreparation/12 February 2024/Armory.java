import java.util.Scanner;

public class Armory {

    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        String[][] matrix = fillMatrix ( scanner );

        int totalProfit = 0;
        int dealFor = 65;

        int[] firstPositionOfOfficer = findOfficer ( matrix );

        int officerRow = firstPositionOfOfficer[0];
        int officerCol = firstPositionOfOfficer[1];

        while (totalProfit < dealFor) {
            int lastRow = officerRow;
            int lastCol = officerCol;

            String command = scanner.nextLine ( );

            switch (command) {
                case "up":
                    officerRow --;
                    break;
                case "down":
                    officerRow++;
                    break;
                case "left":
                    officerCol--;
                    break;
                case "right":
                    officerCol++;
                    break;
            }

            if ( !isOfficerStillIn(officerRow,officerCol, matrix)){
                matrix[lastRow][lastCol] = "-";
                break;

            }

            String scenario = matrix[officerRow][officerCol];

            if (scenario.equals ( "M" )){
                int[] nextMirror = findMirror ( matrix,officerRow,officerCol );
                matrix[officerRow][officerCol] = "-";

                officerRow = nextMirror[0];
                officerCol = nextMirror[1];

            }else if(scenario.matches ( "\\d+" )){
                totalProfit += Integer.parseInt ( matrix[officerRow][officerCol] );

            }
            matrix[officerRow][officerCol] = "A";
            matrix[lastRow][lastCol] = "-";

        }
        String win = "Very nice swords, I will come back for more!";
        String lose = "I do not need more swords!";

        System.out.println ( isOfficerStillIn ( officerRow,officerCol,matrix )? win:lose );

        System.out.printf ( "The king paid %d gold coins.%n", totalProfit );

        printMatrix(matrix);

    }

    private static void printMatrix ( String[][] matrix ) {
       for ( String[] row: matrix ){
           System.out.println ( String.join ( "",row ) );
       }
    }

    private static int[] findMirror ( String[][] matrix, int officerRow, int officerCol ) {
        int[] coordinates = new int[2];
        for ( int row = 0 ; row < matrix.length ; row++ ) {
            for ( int col = 0 ; col < matrix[row].length ; col++ ) {
                if (row == officerRow && col == officerCol){
                    continue;

                }
                if ( matrix[row][col].equals ( "M" ) ) {
                    coordinates[0] = row;
                    coordinates[1] = col;

                }
            }
        }
        return coordinates;
    }

    private static boolean isOfficerStillIn ( int officerRow, int officerCol, String[][] matrix ) {
        return officerRow >= 0 && officerRow < matrix.length && officerCol >= 0 && officerCol < matrix.length;
    }

    private static int[] findOfficer ( String[][] matrix ) {
        int[] coordinates = new int[2];
        for ( int row = 0 ; row < matrix.length ; row++ ) {
            for ( int col = 0 ; col < matrix[row].length ; col++ ) {
                if ( matrix[row][col].equals ( "A" ) ) {
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
