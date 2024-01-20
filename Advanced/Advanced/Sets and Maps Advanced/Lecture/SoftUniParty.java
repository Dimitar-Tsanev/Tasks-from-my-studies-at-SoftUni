import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    private static final Scanner scanner = new Scanner ( System.in );
    public static void main ( String[] args ) {

        Set<String> vipGuests = new TreeSet<> (  );
        Set<String> normalGuests = new TreeSet<> (  );

        addGuests ( vipGuests,normalGuests );
        removeGuests ( vipGuests,normalGuests );

        System.out.println (vipGuests.size () + normalGuests.size () );
        vipGuests.forEach ( System.out::println );
        normalGuests.forEach ( System.out::println );
    }
    private static void addGuests (Set<String> vipGuests, Set<String> normalGuests){
        String input = scanner.nextLine ();
        while (!"PARTY".equals ( input )){
            if (Character.isDigit ( input.charAt ( 0 ) )){
                vipGuests.add ( input );

            }else {
                normalGuests.add ( input );

            }
            input = scanner.nextLine ();
        }
    }
    private static void removeGuests (Set<String> vipGuests, Set<String> normalGuests){
        String input = scanner.nextLine ();

        while (!"END".equals ( input )){
            vipGuests.remove ( input );
            normalGuests.remove ( input );

            input = scanner.nextLine ();
        }
    }
}
