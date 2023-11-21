import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        String input = scanner.nextLine ( );

        Pattern pattern = Pattern.compile ( "([=/])(?<location>[A-Z][a-zA-Z]{2,})\\1" );
        Matcher matcher = pattern.matcher ( input );

        List<String> locations = new ArrayList<> ();
        int travelPoints = 0;

        while (matcher.find ()){
            String location = matcher.group ( "location");

            travelPoints += location.length ();

            locations.add ( location );

        }
        System.out.println ( "Destinations: " + String.join ( ", ",locations ));
        System.out.println ( "Travel Points: " + travelPoints );
    }
}
