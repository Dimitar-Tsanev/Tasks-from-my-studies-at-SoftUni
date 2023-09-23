package DataTypesAndVariablesExercise;

import java.util.Scanner;

public class Elevator {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        int persons = Integer.parseInt ( scan.nextLine ( ) );
        int elevatorCapacity = Integer.parseInt ( scan.nextLine ( ) );
        int elevatorCourses = 0;
        while (persons > 0){
            elevatorCourses++;
            persons -= elevatorCapacity;
        }
        System.out.println ( elevatorCourses );
    }
}
