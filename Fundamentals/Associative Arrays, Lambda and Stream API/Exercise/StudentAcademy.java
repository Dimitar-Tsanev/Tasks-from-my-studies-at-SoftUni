import java.util.*;

public class StudentAcademy {
    public static void main ( String[] args ) {
        Scanner scanner =new Scanner ( System.in );

        LinkedHashMap <String, List<Double>> studentsGrades = new LinkedHashMap<> ();

        int gradesNumber = Integer.parseInt ( scanner.nextLine ( ) );

        for ( int i = 0 ; i < gradesNumber ; i++ ) {
            String name = scanner.nextLine ( );
            double grade = Double.parseDouble ( scanner.nextLine ());

            if ( studentsGrades.containsKey ( name ) ){
                studentsGrades.get ( name ).add ( grade );
            }else {
                studentsGrades.put ( name, new ArrayList<> () );
                studentsGrades.get ( name ).add ( grade );
            }
        }
        for ( Map.Entry<String, List<Double>> student: studentsGrades.entrySet ()  ) {
            double averageGrade = student.getValue ( ).stream ( ).mapToDouble ( grade -> grade ).average ().getAsDouble ();
            if (averageGrade >= 4.50){
                System.out.printf ( "%s -> %.2f%n", student.getKey (), averageGrade );
            }
        }
    }
}
