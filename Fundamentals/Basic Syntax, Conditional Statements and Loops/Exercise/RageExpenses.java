import java.util.Scanner;

public class RageExpenses {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        int lostGames = Integer.parseInt ( scan.nextLine ( ) );
        double headsetPrice = Double.parseDouble ( scan.nextLine ( ) );
        double mousePrice = Double.parseDouble ( scan.nextLine ( ) );
        double keyboardPrice = Double.parseDouble ( scan.nextLine ( ) );
        double displayPrice = Double.parseDouble ( scan.nextLine () );
        double rageExpenses = 0.0;
        int keyboardCounter = 0;
        for ( int i = 1 ; i <= lostGames  ; i++ ) {
            if ( i % 2 == 0 ){
                rageExpenses += headsetPrice;
            }
            if ( i % 3 == 0){
                rageExpenses +=mousePrice;
            }
            if (i % 3 == 0 && i % 2 == 0 ){
                rageExpenses += keyboardPrice;
                keyboardCounter++;
            }
            if (keyboardCounter > 0 && keyboardCounter % 2 == 0){
                rageExpenses += displayPrice;
                keyboardCounter = 0;
            }
        }
        System.out.printf ( "Rage expenses: %.2f lv.", rageExpenses );
    }
}
