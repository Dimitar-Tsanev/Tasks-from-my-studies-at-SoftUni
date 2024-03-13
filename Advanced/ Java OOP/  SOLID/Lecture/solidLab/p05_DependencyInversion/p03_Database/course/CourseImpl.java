package solidLab.p05_DependencyInversion.p03_Database.course;

public class CourseImpl implements Course{
    private static Integer nextId = 1;
    private String name;
    private Integer id;

    public CourseImpl ( String name ) {
        this.setName ( name );
        this.setId ();
    }

    private void setName ( String name ) {
        if (name == null || name.isBlank ()){
            throw new IllegalArgumentException("Missing course name!");
        }
        this.name = name;
    }

    private void setId (  ) {
        this.id = nextId++;
    }

    @Override
    public String getName () {
        return this.name;
    }

    @Override
    public Integer getId () {
        return this.id;
    }
}
