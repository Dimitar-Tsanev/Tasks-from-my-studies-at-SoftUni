package Students;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );

        List <Student> students = new ArrayList<> ();
        String input = scan.nextLine ( );

        while (!input.equals ( "end" )){
            String [] studentInformation = input.split ( " " );
            Student student = new Student ( studentInformation [0],
                    studentInformation [1],
                    Integer.parseInt ( studentInformation [2]),
                    studentInformation [3] );
            students.add ( student );

            input = scan.nextLine ( );
        }
        String filterTown = scan.nextLine ();
        for ( Student student: students ) {
            if (student.getTown ().equals ( filterTown )){
                System.out.println ( student.formatInformation () );
            }
        }
    }
}
