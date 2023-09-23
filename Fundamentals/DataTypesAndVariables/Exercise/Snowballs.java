package DataTypesAndVariablesExercise;

import java.util.Scanner;

public class Snowballs {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        int snowballsNumber = Integer.parseInt ( scan.nextLine ( ) );
        double bestSnowballValue = Integer.MIN_VALUE;
        int bestSnowballSnow = 0;
        int bestSnowballTime = 0;
        int bestSnowballQuality = 0;
        for ( int currentSnowball = 1 ; currentSnowball <= snowballsNumber  ; currentSnowball++ ) {
            int snowballSnow = Integer.parseInt ( scan.nextLine ( ) );
            int snowballTime = Integer.parseInt ( scan.nextLine ( ) );
            int snowballQuality = Integer.parseInt ( scan.nextLine ( ) );
            double snowballValue = Math.pow (((double) snowballSnow / snowballTime), snowballQuality );
            if (bestSnowballValue < snowballValue){
                bestSnowballValue = snowballValue;
                bestSnowballQuality = snowballQuality;
                bestSnowballSnow = snowballSnow;
                bestSnowballTime = snowballTime;
            }
        }
        System.out.printf ( "%d : %d = %.0f (%d)",
                bestSnowballSnow,
                bestSnowballTime,
                bestSnowballValue,
                bestSnowballQuality );
    }
}
