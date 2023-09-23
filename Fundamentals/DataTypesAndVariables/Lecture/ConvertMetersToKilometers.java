package DataTypesAndVariablesLecture;

import java.util.Scanner;

public class ConvertMetersToKilometers {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        int meters = Integer.parseInt ( scan.nextLine () );
        double kilometers = meters / 1000.0;
        System.out.printf ( "%.2f", kilometers );

    }
}
