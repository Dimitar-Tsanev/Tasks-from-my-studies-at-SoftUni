import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        LinkedHashMap <String, Integer> productsQuantity = new LinkedHashMap<> ();
        LinkedHashMap <String, Double> productsPrices = new LinkedHashMap<> ();

        String input = scanner.nextLine ( );

        while (!input.equals ( "buy" )){
            String[] productData = input.split ( " " );
            String product = productData [0];
            double price = Double.parseDouble ( productData[1] );
            int quantity = Integer.parseInt ( productData[2] );

            if ( productsPrices.containsKey ( product ) ){
                productsPrices.put ( product, price );
                productsQuantity.put ( product, productsQuantity.get ( product ) + quantity );

            }else {
                productsPrices.put ( product,price );
                productsQuantity.put ( product,quantity );

            }
            input = scanner.nextLine ( );
        }
        for ( Map.Entry<String, Integer> product: productsQuantity.entrySet () ) {
            System.out.printf ( "%s -> %.2f%n", product.getKey (), product.getValue () * productsPrices.get ( product.getKey () ) );
        }
    }
}
