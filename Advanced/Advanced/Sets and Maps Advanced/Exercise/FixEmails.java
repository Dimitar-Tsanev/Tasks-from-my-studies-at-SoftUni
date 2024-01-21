import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main ( String[] args ) {

        /*You are given a sequence of strings, each on a new line,
        until you receive the "stop" command. The first string is a name of a person.
        On the second line, you receive his email.
        Your task is to collect their names and emails and remove emails whose domain
        ends with "us", "uk," or "com" (case insensitive). Print in the following format:
        "{name} – > {email}" */

        Scanner scanner = new Scanner ( System.in );

        Map<String, String> personsEmails = new LinkedHashMap<> (  );

        String name = scanner.nextLine ();

        while (!"stop".equals ( name )){
            String email = scanner.nextLine ( );
            String domain = email.split ( "@" )[1];
            String[] suffix = domain.split ( "\\." );
            String end = suffix [suffix.length -1].toLowerCase (  );

            if (!"us".equals ( end ) && !"uk".equals ( end ) && !"com".equals ( end )){
                personsEmails.put ( name, email);
            }

            name = scanner.nextLine ( );
        }
        personsEmails.forEach ( (k,v) -> System.out.println ( k + " -> " + v ) );
    }
}
