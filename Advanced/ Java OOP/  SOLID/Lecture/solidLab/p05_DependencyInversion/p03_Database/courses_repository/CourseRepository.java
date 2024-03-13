package solidLab.p05_DependencyInversion.p03_Database.courses_repository;

import java.util.Collection;

public interface CourseRepository {
    Collection<Integer> courseIds ();

    Collection<String> courseNames ();

    String getCourseById ( int id );
    Collection<String> search ( String substring );
}
