import java.text.DecimalFormat;
import java.util.Scanner;

public class BonusScoringSystem {
    public static void main ( String[] args ) {

        Scanner scan = new Scanner ( System.in );

        int students = Integer.parseInt ( scan.nextLine () );
        int lecturesCount = Integer.parseInt ( scan.nextLine () );
        int additionalBonus = Integer.parseInt ( scan.nextLine ( ) );

        double maxBonus = 0;
        int maxBonusStudentAttendances = 0;

        for ( int i = 1 ; i <= students  ; i++ ) {
            int studentAttendances = Integer.parseInt ( scan.nextLine ( ) );
            double totalBonus = (studentAttendances * 1.0 / lecturesCount) *
                    (5 + additionalBonus);

            if (totalBonus > maxBonus){
                maxBonus = totalBonus;
                maxBonusStudentAttendances = studentAttendances;
            }
        }
        System.out.printf ( "Max Bonus: %s.%n",
                new DecimalFormat ( "0" )
                        .format ( Math.ceil ( maxBonus ) ));

        System.out.printf ( "The student has attended %d lectures.%n", maxBonusStudentAttendances );
    }

}
