import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class FilterByAge {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        List <String> persons = new ArrayList<> ();

        int numberOfPersons = Integer.parseInt ( scanner.nextLine ( ) );

        for ( int i = 0 ; i < numberOfPersons ; i++ ) {
            String input = scanner.nextLine ( );
            persons.add ( input );
        }

        String condition = scanner.nextLine ( );
        int ageToTest = Integer.parseInt ( scanner.nextLine ( ) );
        String format = scanner.nextLine ( );

        BiFunction<String, Integer, Predicate<Integer>> getCondition = ( c, a ) -> {
            if ( c.equals ( "younger" ) ) {
                return y -> y <= a;
            }
            return y -> y >= a;
        };
        Predicate<Integer> testAge = getCondition.apply ( condition, ageToTest );

        Function<String, Integer> returnsAge = (s) -> {
            int a;
            a = Integer.parseInt ( s.split ( ",\\s+" )[1] );
            return a;
        };
        Function <String, BiFunction<String, Integer,String>> getFormat = form -> {
            switch (form){
                case "age":
                    return (s,i) -> String.format ("%d", i);
                case "name":
                    return (s,i) -> String.format ("%s", s);
                default:
                    return (s,i) -> String.format ("%s - %d", s,i);
            }
        };
        BiFunction<String,Integer,String> printFormat = getFormat.apply ( format );

        for ( String person : persons ) {
            String name = person.split ( ",\\s+" )[0];
            Integer age = returnsAge.apply ( person );
            if ( testAge.test ( age ) ) {
                System.out.println ( printFormat.apply ( name,age ) );
            }
        }
    }
}