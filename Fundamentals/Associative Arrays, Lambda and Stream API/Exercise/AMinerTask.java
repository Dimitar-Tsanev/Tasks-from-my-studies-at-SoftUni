import java.util.LinkedHashMap;
import java.util.Scanner;

public class AMinerTask {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        LinkedHashMap <String, Integer> resourceQuantity = new LinkedHashMap<> ();

        String input = scanner.nextLine ( );

        while (!input.equals ( "stop" )){
            int quantity = Integer.parseInt ( scanner.nextLine ());
            if (resourceQuantity.containsKey ( input )){
                resourceQuantity.put ( input, resourceQuantity.get ( input ) + quantity );
            }else {
                resourceQuantity.put ( input, quantity );
            }
            input = scanner.nextLine ();
        }
        resourceQuantity.forEach ( ( key, value ) -> System.out.printf ( "%s -> %d%n", key, value ) );
    }
}
