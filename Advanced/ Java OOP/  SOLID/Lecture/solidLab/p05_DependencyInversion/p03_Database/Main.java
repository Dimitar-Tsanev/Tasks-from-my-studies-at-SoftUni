package solidLab.p05_DependencyInversion.p03_Database;

import solidLab.p05_DependencyInversion.p03_Database.course.Course;
import solidLab.p05_DependencyInversion.p03_Database.course.CourseImpl;
import solidLab.p05_DependencyInversion.p03_Database.courses_repository.CourseRepository;
import solidLab.p05_DependencyInversion.p03_Database.courses_repository.Data;

import java.util.List;

public class Main {
    public static void main ( String[] args ) {
        List<Course> coursesList = List.of ( new CourseImpl ( "Programming basic" ),
                new CourseImpl ( "Programming fundamentals" ),
                new CourseImpl ( "Programming advanced" ) );

        CourseRepository repository = new Data ( coursesList );

        CoursesManager manager = new CoursesManager ( repository );

        manager.printAll ();
        manager.printById ( 2 );
        manager.printIds ();
        manager.printSearchedSubstring ( "advanced" );

    }
}
