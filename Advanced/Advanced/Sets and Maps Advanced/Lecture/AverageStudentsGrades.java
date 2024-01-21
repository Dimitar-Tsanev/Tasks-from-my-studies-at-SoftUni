import java.util.*;

public class AverageStudentsGrades {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        int numberOfStudents = Integer.parseInt ( scanner.nextLine ());

        Map<String, List<Double>> studentsGrades = new TreeMap<> (  );

        for ( int i = 0 ; i < numberOfStudents ; i++ ) {
            String[] input = scanner.nextLine ( ).split ( "\\s+" );
            String studentName = input[0];
            double grade = Double.parseDouble ( input[1] );

            studentsGrades.putIfAbsent ( studentName,new ArrayList<> () );
            studentsGrades.get ( studentName ).add ( grade );

        }
        for ( Map.Entry<String, List<Double>> student: studentsGrades.entrySet () ){
            double sum = 0.00;
            for ( double grade: student.getValue ( ) ){
                sum +=grade;

            }
            double average = sum /student.getValue ().size ();
            System.out.print ( student.getKey () + " -> " );
            student.getValue ().forEach ( v -> System.out.printf ( "%.2f ",v ));
            System.out.printf ( "(avg: %.2f)%n",average );

        }
    }
}
