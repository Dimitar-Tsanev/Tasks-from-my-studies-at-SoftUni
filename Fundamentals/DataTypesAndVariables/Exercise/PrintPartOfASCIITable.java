package DataTypesAndVariablesExercise;

import java.util.Scanner;

public class PrintPartOfASCIITable {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        int startAscii = Integer.parseInt ( scan.nextLine () );
        int endingAscii = Integer.parseInt ( scan.nextLine ( ) );
        for ( int currentCode = startAscii ; currentCode <= endingAscii ; currentCode++ ) {
            System.out.printf ("%c ",(char) currentCode);
        }
    }
}
