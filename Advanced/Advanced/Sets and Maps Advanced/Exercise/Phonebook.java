import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        Map<String, String> phonebook = new HashMap<> ();

        String contact = scanner.nextLine ();

        while (!"search".equals ( contact )){
            String contactName = contact.split ( "-" )[0];
            String number = contact.split ( "-" )[1];

            phonebook.put ( contactName, number );

            contact = scanner.nextLine ();

        }
        contact = scanner.nextLine ();

        while (!"stop".equals ( contact )){
            if ( phonebook.containsKey ( contact ) ){
                System.out.printf ("%s -> %s%n",contact, phonebook.get ( contact ) );

            }else {
                System.out.printf ( "Contact %s does not exist.%n",contact );

            }
            contact = scanner.nextLine ();
        }
    }
}
