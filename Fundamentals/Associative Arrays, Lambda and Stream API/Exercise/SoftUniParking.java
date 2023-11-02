import java.util.LinkedHashMap;
import java.util.Scanner;

public class SoftUniParking {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        LinkedHashMap <String, String> usersAndPlatedNumbers = new LinkedHashMap<> ();

        int numberOfCommands = Integer.parseInt ( scanner.nextLine ());

        for ( int i = 1 ; i <=numberOfCommands  ; i++ ) {
            String [] commandLine = scanner.nextLine ().split ( " " );
            String command = commandLine[0];
            String username = commandLine[1];


            if(command.equals ( "register" )){
                if (usersAndPlatedNumbers.containsKey ( username )){
                    System.out.printf ( "ERROR: already registered with plate number %s%n", usersAndPlatedNumbers.get ( username ) );
                }else{
                    String platedNumber = commandLine[2];
                    usersAndPlatedNumbers.put ( username, platedNumber );
                    System.out.printf ( "%s registered %s successfully%n",username,platedNumber );
                }

            }else if (command.equals ( "unregister" )){
                if(!usersAndPlatedNumbers.containsKey ( username )){
                    System.out.printf ( "ERROR: user %s not found%n",username );
                }else{
                    usersAndPlatedNumbers.remove ( username );
                    System.out.printf ( "%s unregistered successfully%n",username );
                }
            }
        }
        usersAndPlatedNumbers.forEach ( (key,value) -> System.out.printf ( "%s => %s%n",key,value ) );

    }
}
