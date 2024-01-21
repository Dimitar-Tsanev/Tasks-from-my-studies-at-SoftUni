import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        int lineNumbers = Integer.parseInt ( scanner.nextLine ());

        Set<String> userNames = new LinkedHashSet<> (  );

        for ( int i = 0 ; i < lineNumbers ; i++ ) {
            String username = scanner.nextLine ();
            userNames.add ( username );
        }
        userNames.forEach ( System.out::println);
    }
}
