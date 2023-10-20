import java.util.Scanner;

public class SoftUniReception {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );

        int [] personalCapacity = new int [3];
        int sumOfTheCapacity = 0;

        for ( int i = 0 ; i < 3 ; i++ ) {
            personalCapacity [i] = Integer.parseInt ( scan.nextLine () );
            sumOfTheCapacity += personalCapacity [i];
        }

        int studentsToBeAnswered = Integer.parseInt ( scan.nextLine () );
        int hourCounter = 0;

        while (studentsToBeAnswered > 0){
            hourCounter++;
            if (hourCounter % 4 != 0){
                studentsToBeAnswered -= sumOfTheCapacity;
            }

        }
        System.out.printf ( "Time needed: %dh.%n",hourCounter );
    }
}
