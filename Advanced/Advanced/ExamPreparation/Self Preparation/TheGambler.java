import java.util.Scanner;

public class TheGambler {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        String[][] matrix = fillMatrix ( scanner );

        int[] playerPosition = findPlayer ( matrix );

        int playerRow = playerPosition[0];
        int playerCol = playerPosition[1];

        int money = 100;
        boolean jackpot = false;

        String command = scanner.nextLine ( );

        while (!"end".equals ( command )){
            matrix[playerRow][playerCol] = "-";

            playerPosition = findNextPosition(command, playerRow,playerCol);

            playerRow = playerPosition[0];
            playerCol = playerPosition[1];

            String scenario = matrix[playerRow][playerCol];

            if (!isStillInside ( playerRow,playerCol,matrix )){
                System.out.println ( "Game over! You lost everything!" );
                return;
            }

            matrix[playerRow][playerCol] = "G";

            switch (scenario){
                case "W":
                    money += 100;
                    break;
                case "P":
                    money -= 200;
                    break;
                case "J":
                    money += 100_000;
                    jackpot = true;
                    break;
            }
            if (money <= 0 || jackpot){
                break;
            }
            command = scanner.nextLine ( );
        }

        if ( money <= 0 ){
            System.out.println ( "Game over! You lost everything!" );
            return;

        } else if ( jackpot ) {
            System.out.println ( "You win the Jackpot!" );

        }
        System.out.printf ( "End of the game. Total amount: %d$%n", money );
        printMatrix ( matrix );
    }
    private static void printMatrix ( String[][] matrix ) {
        for ( String[] row: matrix ){
            System.out.println ( String.join ( "",row ) );
        }
    }

    private static int[] findNextPosition ( String command, int row, int col ) {
        switch (command) {
            case "up":
                row --;
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
        return new int[] {row, col};
    }

    private static boolean isStillInside ( int officerRow, int officerCol, String[][] matrix ) {
        return officerRow >= 0 && officerRow < matrix.length && officerCol >= 0 && officerCol < matrix.length;
    }
    private static int[] findPlayer ( String[][] matrix ) {
        int[] coordinates = new int[2];
        for ( int row = 0 ; row < matrix.length ; row++ ) {
            for ( int col = 0 ; col < matrix[row].length ; col++ ) {
                if ( matrix[row][col].equals ( "G" ) ) {
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
