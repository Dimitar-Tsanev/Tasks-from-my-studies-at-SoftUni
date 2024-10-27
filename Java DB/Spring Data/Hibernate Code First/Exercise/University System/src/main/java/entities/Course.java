package entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collections;
import java.util.Set;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;

    @Basic(optional = false)
    private String name;

    @Basic
    private String description;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "end_date", nullable = false)
    private Date endDate;

    @Basic(optional = false)
    private int credits;

    @ManyToOne()
    @JoinColumn( name = "teacher_id", referencedColumnName = "id")
    private Teacher teacher;

    @ManyToMany(mappedBy = "courses", targetEntity = Student.class)
    private Set<Student> students;

    public Course () {
    }

    public long getId () {
        return id;
    }

    public Set<Student> getStudents () {
        return Collections.unmodifiableSet ( this.students );
    }

    public void addStudents ( Student student ) {
        this.students.add ( student );
    }

    public Teacher getTeacher () {
        return teacher;
    }

    public void setTeacher ( Teacher teacher ) {
        this.teacher = teacher;
    }

    public int getCredits () {
        return credits;
    }

    public void setCredits ( int credits ) {
        this.credits = credits;
    }

    public Date getEndDate () {
        return endDate;
    }

    public void setEndDate ( Date endDate ) {
        this.endDate = endDate;
    }

    public Date getStartDate () {
        return startDate;
    }

    public void setStartDate ( Date startDate ) {
        this.startDate = startDate;
    }

    public String getDescription () {
        return description;
    }

    public void setDescription ( String description ) {
        this.description = description;
    }

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }
}
