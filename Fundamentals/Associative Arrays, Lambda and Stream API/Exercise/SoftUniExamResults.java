import java.util.LinkedHashMap;
import java.util.Scanner;

public class SoftUniExamResults {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        LinkedHashMap<String, Integer> languagesSubmissions = new LinkedHashMap<> ();
        LinkedHashMap<String, Integer> usersPoints = new LinkedHashMap<> ();

        String input = scanner.nextLine ( );

        while (!input.equals ( "exam finished" )){
            String[] commandLine = input.split ( "-" );

            String user = commandLine[0];
            String language = commandLine[1];

            if (language.equals ( "banned" )){
                usersPoints.remove ( user );

                input = scanner.nextLine ();
                continue;
            }

            int points = Integer.parseInt ( commandLine[2] );

            if (!languagesSubmissions.containsKey ( language )){
                languagesSubmissions.put ( language, 1 );

            }else {
                languagesSubmissions.put ( language, languagesSubmissions.get ( language ) + 1 );

            }

            if ( !usersPoints.containsKey ( user ) ){
                usersPoints.put ( user, points );

            }else{
                if ( usersPoints.get ( user ) < points){
                    usersPoints.put ( user, points );
                }
            }

            input = scanner.nextLine ( );
        }

        System.out.println ( "Results:" );
        usersPoints.forEach (( key, value ) -> System.out.println ( key + " | " + value ));

        System.out.println ( "Submissions:" );
        languagesSubmissions.forEach ( (key, value) -> System.out.println ( key + " - " +value ) );
    }
}
