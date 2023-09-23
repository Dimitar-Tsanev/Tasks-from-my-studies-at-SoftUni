import java.util.Scanner;

public class Orders {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        int orders = Integer.parseInt ( scan.nextLine () );
        double total =0.0;
        for ( int i = 1 ; i <= orders  ; i++ ) {
            double pricePerCapsule = Double.parseDouble ( scan.nextLine ( ) );
            int daysInMonth = Integer.parseInt ( scan.nextLine () );
            int capsulesCount = Integer.parseInt ( scan.nextLine ( ) );
            double coffeePrice = ((daysInMonth * capsulesCount) * pricePerCapsule);
            total += coffeePrice;
            System.out.printf ( "The price for the coffee is: $%.2f%n", coffeePrice );
        }
        System.out.printf ( "Total: $%.2f", total );
    }
}
