package DataTypesAndVariablesExercise;

import java.util.Scanner;

public class WaterOverflow {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        int timesPour = Integer.parseInt ( scan.nextLine () );
        int littersInTheTank = 0;
        for ( int currentPour = 1 ; currentPour <= timesPour  ; currentPour++ ) {
            int incomingLitters = Integer.parseInt ( scan.nextLine () );
                if ( incomingLitters <= 255 && incomingLitters + littersInTheTank <= 255 ) {
                    littersInTheTank += incomingLitters;

                } else {
                    System.out.println ( "Insufficient capacity!" );
                }
        }
        System.out.println ( littersInTheTank );
    }
}
