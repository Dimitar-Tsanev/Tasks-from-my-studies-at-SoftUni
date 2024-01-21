import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        Map<String, Double[]> studentsGrades = new TreeMap<> ();

        int numberOfStudents = Integer.parseInt ( scanner.nextLine () );

        for ( int i = 0 ; i < numberOfStudents ; i++ ) {
            String name = scanner.nextLine ( );
            String[] scores = scanner.nextLine ().split ( "\\s+" );
            Double[] grades = new Double[scores.length];

            for ( int j = 0 ; j < scores.length ; j++ ) {
                grades[j] = Double.parseDouble ( scores[j] );
            }
            studentsGrades.put ( name,grades );
        }
        for ( Map.Entry<String, Double[]> student : studentsGrades.entrySet () ) {
            double sumOfGrades = 0.00;
            for ( Double grade: student.getValue () ){
                sumOfGrades += grade;

            }
            double averageGrade = sumOfGrades / student.getValue ().length;
            System.out.println ( student.getKey () + " is graduated with " + averageGrade);
        }
    }
}
