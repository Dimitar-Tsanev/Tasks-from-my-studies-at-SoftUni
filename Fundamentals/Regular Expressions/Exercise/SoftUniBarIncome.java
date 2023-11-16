import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        String input = scanner.nextLine ( );

        double total = 0.0;

        while (!input.equals ( "end of shift" )) {

            Pattern namePattern = Pattern.compile ( "%(?<name>[A-Z][a-z]+)%" );
            Matcher nameMatcher = namePattern.matcher ( input );

            Pattern productPattern = Pattern.compile ( "<(?<product>\\w+)>" );
            Matcher productMatcher = productPattern.matcher ( input );

            Pattern countPattern = Pattern.compile ( "\\|(?<count>\\d+)\\|" );
            Matcher countMatcher = countPattern.matcher ( input );

            Pattern pricePattern = Pattern.compile ( "(?<price>\\d+[.\\d+]*)\\$" );
            Matcher priceMatcher = pricePattern.matcher ( input );

            boolean haveName = nameMatcher.find ( );
            boolean haveProduct = productMatcher.find ( );
            boolean haveCount = countMatcher.find ( );
            boolean havePrice = priceMatcher.find ( );

            if ( haveName && haveProduct && haveCount && havePrice ) {
                String name = nameMatcher.group ("name");
                String product = productMatcher.group ("product");
                int count = Integer.parseInt ( countMatcher.group ( "count" ) );
                double price = Double.parseDouble ( priceMatcher.group ( "price" ) );

                double totalPrice = price * count;
                total += totalPrice;

                System.out.printf ( "%s: %s - %.2f%n", name, product, totalPrice );
            }
            input = scanner.nextLine ( );
        }
        System.out.printf("Total income: %.2f%n",total );
    }
}
