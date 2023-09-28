package Exercise;

import java.util.Scanner;

public class Train {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        int wagons = Integer.parseInt ( scan.nextLine () );
        int [] peoplesInWagon = new int [wagons];
        int allPeoplesInTheTrain = 0;
        for ( int i = 0 ; i < wagons ; i++ ) {
            peoplesInWagon [i] = Integer.parseInt ( scan.nextLine ( ) );
            allPeoplesInTheTrain += peoplesInWagon [i];
        }
        for ( Integer i: peoplesInWagon) {
            System.out.print ( i + " " );
        }
        System.out.println ( );
        System.out.println ( allPeoplesInTheTrain );
    }
}
