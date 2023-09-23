package DataTypesAndVariablesExercise;

import java.util.Scanner;

public class SpiceMustFlow {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        int startingYield = Integer.parseInt ( scan.nextLine ( ) );
         int daysCounter = 0;
         int totalSpiceProduced = 0;
        while (startingYield >= 100){
            daysCounter++;
            totalSpiceProduced += startingYield - 26;
            startingYield -= 10;
        }
        if (totalSpiceProduced > 0){
            totalSpiceProduced -=26;
        }
        System.out.println ( daysCounter );
        System.out.println ( totalSpiceProduced );
    }
}
