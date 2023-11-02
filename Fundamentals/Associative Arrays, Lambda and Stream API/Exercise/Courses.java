import java.util.*;

public class Courses {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        LinkedHashMap<String, List<String>> studentsInCourses = new LinkedHashMap<> ();

        String input = scanner.nextLine ( );

        while (!input.equals ( "end" )){
            String course = input.split ( " : " )[0];
            String student = input.split ( " : " )[1];

            if (!studentsInCourses.containsKey ( course )){
                studentsInCourses.put ( course, new ArrayList<> () );
                studentsInCourses.get ( course ).add ( student );
            }else{
                studentsInCourses.get ( course ).add ( student );
            }
            input = scanner.nextLine ( );
        }
        for ( Map.Entry<String, List<String>> course: studentsInCourses.entrySet ()) {
            System.out.printf ( "%s: %d%n", course.getKey (), course.getValue ().size ());
            for ( String student: course.getValue () ) {
                System.out.printf ( "-- %s%n",student );
            }
        }
    }
}
