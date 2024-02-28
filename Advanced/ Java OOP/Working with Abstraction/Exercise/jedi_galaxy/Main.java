package jedi_galaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        String input = scanner.nextLine ();

        int[][] filed = inhabitFiled ( input );

        Player player = new Player ();

        input = scanner.nextLine ( );

        while (!"Let the Force be with you".equals ( input ) ) {
            player.setPlayerCoordinates ( getCoordinates ( input ) );

            input = scanner.nextLine ( );

            Enemy enemy = new Enemy ( getCoordinates ( input) );

            destroyResources ( enemy, filed);

            getterResources ( player,filed );

            input = scanner.nextLine ( );
        }
        System.out.println ( player.getSumOfResources ());
    }
    private static void getterResources ( Player player, int[][] field){
        while (player.getRow ( ) >= 0 && player.getCol () < field[field.length - 1].length) {
            if (isCoordinatesInTheField ( player.getRow ( ), player.getCol ( ),field ) ) {
                player.addResources (field[player.getRow ( )][player.getCol ( )] );

            }
            player.movePlayer ();
        }
    }
    private static void destroyResources( Enemy enemy, int[][] field){
        while (enemy.getRow ( ) >= 0 && enemy.getCol ( ) >= 0) {
            if (isCoordinatesInTheField ( enemy.getRow ( ), enemy.getCol ( ),field ) ) {
                field[enemy.getRow ( )][enemy.getCol ( )] = 0;

            }
            enemy.moveEnemy ();
        }
    }
    private static boolean isCoordinatesInTheField(int row, int col, int[][] field){
        return  row >= 0 && row < field.length && col >= 0 && col < field[row].length;
    }
    private static int[][] inhabitFiled(String input){
        int[] largestCoordinates = getCoordinates ( input );

        int rows = largestCoordinates[0];
        int cols = largestCoordinates[1];

        int[][] field = new int[rows][cols];

        int cellValue = 0;
        for ( int row = 0 ; row < rows ; row++ ) {
            for ( int col = 0 ; col < cols ; col++ ) {
                field[row][col] = cellValue++;
            }
        }
        return field;
    }
    private static int[] getCoordinates (String input){
        return Arrays.stream ( input.split ( " " ) )
                .mapToInt ( Integer::parseInt )
                .toArray ( );
    }
}