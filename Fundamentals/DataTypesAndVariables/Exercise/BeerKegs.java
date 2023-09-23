package DataTypesAndVariablesExercise;

import java.util.Scanner;

public class BeerKegs {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        int numberOfKegs = Integer.parseInt ( scan.nextLine () );
        String maxKegVolumeName = "";
        double maxKegVolume = 0;
        for ( int currentKeg = 1 ; currentKeg <= numberOfKegs  ; currentKeg++ ) {
            String kegName = scan.nextLine ();
            double radius = Double.parseDouble ( scan.nextLine () );
            int height = Integer.parseInt ( scan.nextLine () );
            double volume = Math.PI * Math.pow ( radius,2 ) * height;
            if (maxKegVolume < volume){
                maxKegVolume = volume;
                maxKegVolumeName = kegName;
            }
        }
        System.out.println ( maxKegVolumeName );
    }
}
