import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        Map<String, Map<String, List<String>>> continentsCountriesAndCities = new LinkedHashMap<> (  );

        int lineNumbers = Integer.parseInt ( scanner.nextLine ( ) );

        for ( int i = 0 ; i < lineNumbers ; i++ ) {
            String[] inputLine = scanner.nextLine ().split ( "\\s+" );
            String continent = inputLine[0];
            String country = inputLine[1];
            String city = inputLine[2];
            continentsCountriesAndCities.putIfAbsent ( continent,new LinkedHashMap<> (  ) );
            continentsCountriesAndCities.get ( continent ).putIfAbsent ( country, new ArrayList<> (  ) );
            continentsCountriesAndCities.get ( continent ).get ( country ).add ( city );

        }
        continentsCountriesAndCities.forEach ( (key,value )->{
            System.out.println (key +":" );
            value.forEach ( (k,v )-> System.out.println ("  "+k +" -> " + String.join ( ", ",v ) ));
        });
    }
}
