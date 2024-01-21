import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        Map<String, Map<String,Double>> supermarketsProductsPrices = new TreeMap<> ();

        String input = scanner.nextLine ( );

        while (!"Revision".equals ( input )){
            String supermarketName = input.split ( ", " )[0];
            String productName = input.split ( ", " )[1];
            double productPrice = Double.parseDouble ( input.split ( ", " )[2] );

            supermarketsProductsPrices.putIfAbsent ( supermarketName, new LinkedHashMap<> () );
            supermarketsProductsPrices.get ( supermarketName ).put ( productName, productPrice );

            input = scanner.nextLine ( );
        }

        supermarketsProductsPrices.forEach ( ( key, value ) -> {
            System.out.printf ( key + "->%n" );
            value.forEach ( ( k, v ) -> System.out.printf ( "Product: %s, Price: %.1f%n", k, v ) );
        } );

    }
}
