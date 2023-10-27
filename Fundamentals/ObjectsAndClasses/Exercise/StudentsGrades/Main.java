package StudentsGrades;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );

        int numberOfStudents = Integer.parseInt ( scan.nextLine () );

        List<Student> students = new ArrayList<> ();

        for ( int i = 0 ; i < numberOfStudents ; i++ ) {
            String [] studentInformation = scan.nextLine ().split ( " " );
            Student student = new Student ( studentInformation[0],
                    studentInformation[1],
                    Double.parseDouble ( studentInformation[2] ) );

            students.add ( student );
        }
        for ( int i = 0 ; i < students.size () - 1 ; i++ ) {
            for ( int j = i + 1 ; j < students.size () ; j++ ) {
                if(students.get ( i).getGrade () < students.get ( j ).getGrade ()){
                    Student bestStudent = students.get ( j );
                    students.remove ( j );
                    students.add( i,bestStudent );
                }
            }
        }
        for ( Student student: students ) {
            System.out.println ( student.getStudentInfo () );
        }
    }
}
