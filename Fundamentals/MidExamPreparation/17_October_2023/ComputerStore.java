import java.util.Scanner;

public class ComputerStore {
    public static void main ( String[] args ) {

        Scanner scan = new Scanner ( System.in );

        String input = scan.nextLine ( );
        double priceWithoutTaxes = 0.00;

        while (!input.equals ( "regular" ) && !input.equals ( "special"  )){
            double price = Double.parseDouble ( input );
            if ( price > 0.00 && price < Double.MAX_VALUE ){
                priceWithoutTaxes += price;
            }else {
                System.out.println ( "Invalid price!"  );
            }
            input = scan.nextLine ();
        }
        if ( priceWithoutTaxes <= 0.00 ){
            System.out.println ( "Invalid order!"  );
            return;
        }
        double taxes = priceWithoutTaxes * 0.2;
        double total = priceWithoutTaxes + taxes;
        if (input.equals ( "special" )){
            total = total - (total * 0.1);
        }
        System.out.println ( "Congratulations you've just bought a new computer!" );
        System.out.printf ( "Price without taxes: %.2f$%n", priceWithoutTaxes );
        System.out.printf ( "Taxes: %.2f$%n", taxes );
        System.out.println ( "-----------" );
        System.out.printf ( "Total price: %.2f$%n", total );
    }
}
