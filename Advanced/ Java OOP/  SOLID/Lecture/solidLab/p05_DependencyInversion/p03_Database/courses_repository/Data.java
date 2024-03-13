package solidLab.p05_DependencyInversion.p03_Database.courses_repository;

import solidLab.p05_DependencyInversion.p03_Database.course.Course;

import java.util.Collection;
import java.util.stream.Collectors;

public class Data implements CourseRepository {

    private Collection<Course> courses;

    public Data ( Collection<Course> courses ) {
        this.setCourses ( courses );
    }

    private void setCourses ( Collection<Course> courses ) {
        if (courses == null || courses.isEmpty ()){
            throw new IllegalArgumentException ( "No Course in the collection!" );
        }
        this.courses = courses;
    }

    @Override
    public Collection<Integer> courseIds () {
        return this.courses.stream ()
                .map(Course::getId)
                .collect( Collectors.toList());
    }
    @Override
    public Collection<String> courseNames () {
        return this.courses.stream ()
                .map(Course::getName)
                .collect( Collectors.toList());
    }
    @Override
    public String getCourseById ( int id ) {
        Course course = this.courses.stream ()
                .filter ( c -> c.getId () == id )
                .findFirst ()
                .orElse(null);

        if(course == null) {
            throw new IllegalArgumentException ("Id didn't exist");
        }

        return course.getName ();

    }

    @Override
    public Collection<String> search ( String substring ) {
        Collection<String> searchResult = this.courses.stream ()
                .map(Course::getName)
                .filter ( s-> s.contains ( substring ) )
                .toList ( );

        if(searchResult.isEmpty ()) {
            throw new IllegalArgumentException ("Course name with the given substring didn't exist");
        }

        return searchResult;
    }
}
