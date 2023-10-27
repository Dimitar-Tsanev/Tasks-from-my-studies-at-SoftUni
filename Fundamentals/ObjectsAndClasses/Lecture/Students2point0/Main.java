package Students2point0;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );

        List <Student> students = new ArrayList<> ();

        String input = scan.nextLine ( );

        while (!input.equals ( "end" )){
            String firstName = input.split ( " " )[0];
            String lastName = input.split ( " " )[1];
            int age = Integer.parseInt ( input.split ( " " )[2] );
            String town = input.split ( " " )[3];

            if(!isStudentExist ( students,firstName,lastName )){
                Student student = new Student ( firstName,lastName,age,town);
                students.add ( student );
            }else {
                for ( Student student : students ) {
                    if ( student.getFirstName ( ).equals ( firstName )
                            && student.getLastName ( ).equals ( lastName ) ) {
                        student.setAge ( age );
                        student.setTown ( town );
                        break;
                    }
                }
            }
            input = scan.nextLine ();
        }
        String townFilter = scan.nextLine ( );

        for ( Student student: students ) {
            if (townFilter.equals ( student.getTown () )){
                System.out.println ( student.studentInformation () );
            }
        }
    }
    public static boolean isStudentExist (List <Student> students, String firstName, String lastName){
        for ( Student studentData : students ) {
            if ( studentData.getFirstName ( ).equals ( firstName )
                    && studentData.getLastName ( ).equals ( lastName ) ) {
                return true;
            }
        }
        return false;
    }

}
