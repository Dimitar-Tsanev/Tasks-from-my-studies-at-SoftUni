import java.util.Scanner;

public class BlackFlag {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        int days = Integer.parseInt ( scan.nextLine () );
        int dailyPlunder = Integer.parseInt ( scan.nextLine ( ) );
        int expectedPlunder = Integer.parseInt ( scan.nextLine ( ) );

        double totalPlunder = 0;
        for ( int day = 1 ; day <= days  ; day++ ) {
            totalPlunder += dailyPlunder;
            if(day % 3 == 0){
                totalPlunder += dailyPlunder * 0.5;
            }
            if (day % 5 == 0){
                totalPlunder -= totalPlunder * 0.3;
            }
        }
        if (totalPlunder >= expectedPlunder){
            System.out.printf ( "Ahoy! %.2f plunder gained.%n", totalPlunder );
        }else {
            double percentPlunder = (totalPlunder / expectedPlunder) * 100;
            System.out.printf ( "Collected only %.2f%% of the plunder.%n", percentPlunder );
        }
    }
}
