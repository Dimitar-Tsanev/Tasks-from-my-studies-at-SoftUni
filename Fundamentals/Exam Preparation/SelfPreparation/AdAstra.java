import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );

        String input = scan.nextLine ( );

        String regex = "([|#])(?<typeOfFood>[A-Za-z]+( [A-Za-z]+)*]*)\\1(?<expirationDate>\\d{2}/\\d{2}/\\d{2})\\1(?<calories>\\d+)\\1";

        Pattern pattern = Pattern.compile ( regex );
        Matcher matcher = pattern.matcher ( input );

        List<String> validItems = new ArrayList<> (  );

        int totalCalories = 0;

        while (matcher.find ()){
            String foodType = matcher.group ("typeOfFood");
            String expirationDate = matcher.group ("expirationDate");
            int calories = Integer.parseInt ( matcher.group ("calories"));

            String validItem = String.format ( "Item: %s, Best before: %s, Nutrition: %d", foodType,expirationDate, calories);
            validItems.add ( validItem );

            totalCalories += calories;
        }

        if ( totalCalories >= 2000 ){
            int days = totalCalories / 2000;
            System.out.printf ( "You have food to last you for: %d days!%n", days );

        }else {
            System.out.println ( "You have food to last you for: 0 days!" );

        }

        validItems.forEach ( System.out::println );
    }
}
