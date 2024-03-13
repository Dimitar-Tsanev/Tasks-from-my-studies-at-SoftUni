package solidLab.p05_DependencyInversion.p03_Database;

import solidLab.p05_DependencyInversion.p03_Database.courses_repository.CourseRepository;

public class CoursesManager {
    private CourseRepository repository;

    public CoursesManager ( CourseRepository repository ) {
        this.setRepository ( repository );
    }

    private void setRepository ( CourseRepository repository ) {
        this.repository = repository;
    }

    public void printAll () {
        repository.courseNames ().forEach ( System.out::println );
    }

    public void printIds () {
        repository.courseIds ().forEach ( System.out::println );
    }

    public void printById ( int id ) {
        System.out.println ( repository.getCourseById ( id ));
    }

    public void printSearchedSubstring ( String substring ) {
        repository.search ( substring ).forEach ( System.out::println );
    }
}
