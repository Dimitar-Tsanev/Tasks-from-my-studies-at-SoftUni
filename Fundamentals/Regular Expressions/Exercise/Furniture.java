import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        String order = scanner.nextLine ( );


        double total = 0.0;
        List<String> boughtFurniture = new ArrayList<> ( );

        while (!order.equals ( "Purchase" )) {
            String regex = ">>(?<furniture>\\w+)<<(?<price>\\d+(\\.\\d+)*)!(?<quantity>\\d+)";

            Pattern pattern = Pattern.compile ( regex );
            Matcher correctInputMatcher = pattern.matcher ( order );

            if ( correctInputMatcher.find ( ) ) {
                String furniture = correctInputMatcher.group ( "furniture" );
                double price = Double.parseDouble ( correctInputMatcher.group ( "price" ));
                int quantity = Integer.parseInt ( correctInputMatcher.group ( "quantity" ));

                boughtFurniture.add ( furniture );
                total += price * quantity ;

            }
            order = scanner.nextLine ( );
        }
        System.out.println ( "Bought furniture:" );
        boughtFurniture.forEach ( System.out::println );
        System.out.printf ( "Total money spend: %.2f", total );
    }
}
