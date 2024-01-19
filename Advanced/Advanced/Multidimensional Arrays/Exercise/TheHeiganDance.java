import java.util.Scanner;

public class TheHeiganDance {
    private static int playerRow;
    private static int playerCol;
    private static String[][] filed = fillMatrix ( );

    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        double bossHp = 3_000_000;
        int cloudSpellDamage = 3_500;
        int eruptionSpellDamage = 6_000;

        int playerHP = 18_500;
        playerRow = 7;
        playerCol = 7;

        double damageDoneToBoss = Double.parseDouble ( scanner.nextLine ( ) );

        String spellName = "";

        while (bossHp > 0 && playerHP > 0) {
            bossHp -= damageDoneToBoss;

            if ( "Plague Cloud".equals ( spellName ) ) {
                playerHP -= cloudSpellDamage;

            }
            if ( bossHp <= 0 || playerHP <= 0 ) {
                break;

            }
            String[] castedSpell = scanner.nextLine ( ).split ( "\\s+" );

            spellName = castedSpell[0];
            int spellRow = Integer.parseInt ( castedSpell[1] );
            int spellCol = Integer.parseInt ( castedSpell[2] );

            switch (spellName) {
                case "Cloud":
                    if ( isPlayerEvade ( spellRow, spellCol ) ) {
                        playerHP -= cloudSpellDamage;
                        spellName = "Plague Cloud";

                    }
                    break;
                case "Eruption":
                    if ( isPlayerEvade ( spellRow, spellCol ) ) {
                        playerHP -= eruptionSpellDamage;

                    }
                    break;
            }
        }
        System.out.printf ( "Heigan: %s%n", bossHp <= 0 ? "Defeated!": String.format ( "%.2f",bossHp )  );
        System.out.printf ( "Player: %s%n", playerHP <=0 ? String.format ( "Killed by %s",spellName) : String.format ( "%d",playerHP ) );
        System.out.printf ( "Final position: %d, %d%n",playerRow,playerCol );
    }

    private static boolean isPlayerEvade ( int spellRow, int spellCol ) {
        if ( playerRow == spellRow && spellCol == playerCol ){
            return true;

        }

        int spellStartRow = spellRow - 1;
        int spellStopRow = spellRow + 1;

        int spellStartCol = spellCol - 1;
        int spellStopCol = spellCol + 1;

        for ( int currentRow = spellStartRow ; currentRow <= spellStopRow ; currentRow++ ) {
            for ( int currentCol = spellStartCol ; currentCol <= spellStopCol ; currentCol++ ) {
                if ( isIndexAreValid ( currentRow, currentCol ) ) {
                    filed[currentRow][currentCol] = "spell";
                }
            }
        }
        if (!"spell".equals ( filed[playerRow][playerCol])){
            return false;

        }
        if (canPlayerMoveUp( )){
           playerRow --;
           return false;

        }
        if (canPlayerMoveRight ( )){
            playerCol++;
            return false;

        }
        if (canPlayerMoveDown ()){
            playerRow++;
            return false;

        }
        if (canPlayerMoveLeft ( )){
            playerCol--;
            return false;

        }
        filed = fillMatrix ();
        return true;
    }

    private static boolean canPlayerMoveLeft () {
        if (!isIndexAreValid ( playerRow ,playerCol - 1 )) {
            return false;

        }
        return !"spell".equals ( filed[playerRow][playerCol - 1] );
    }

    private static boolean canPlayerMoveDown ( ) {
        if (!isIndexAreValid ( playerRow + 1,playerCol )) {
            return false;

        }
        return !"spell".equals ( filed[playerRow + 1][playerCol] );
    }

    private static boolean canPlayerMoveRight ( ) {
        if (!isIndexAreValid ( playerRow ,playerCol + 1 )) {
            return false;

        }
        return !"spell".equals ( filed[playerRow][playerCol + 1] );
    }

    private static boolean canPlayerMoveUp ( ) {
        if (!isIndexAreValid ( playerRow - 1,playerCol )) {
           return false;

        }
        return !"spell".equals ( filed[playerRow - 1][playerCol] );
    }

    private static boolean isIndexAreValid ( int currentRow, int currentCol ) {
        return currentRow >= 0 && currentRow < filed.length && currentCol >= 0 && currentCol < filed.length;
    }

    private static String[][] fillMatrix () {
        String[][] matrix = new String[15][15];
        for ( int row = 0 ; row < 15 ; row++ ) {
            for ( int col = 0 ; col < 15 ; col++ ) {
                matrix[row][col] = "available";
            }
        }
        return matrix;
    }
}
