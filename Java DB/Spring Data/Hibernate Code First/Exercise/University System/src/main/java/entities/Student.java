package entities;

import jakarta.persistence.*;

import java.util.Collections;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student extends Person {

    @Column(name = "average_grade")
    private Double averageGrade;

    @Basic
    private Integer attendance;

    @ManyToMany
    @JoinTable(name = "students_courses",
            joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"))
    private Set<Course> courses;

    public Student () {
    }

    public Double getAverageGrade () {
        return averageGrade;
    }

    public void setAverageGrade ( Double averageGrade ) {
        this.averageGrade = averageGrade;
    }

    public Integer getAttendance () {
        return attendance;
    }

    public void setAttendance ( Integer attendance ) {
        this.attendance = attendance;
    }

    public Set<Course> getCourses () {
        return Collections.unmodifiableSet ( courses );
    }

    public void addCourses ( Course course ) {
        this.courses.add ( course );
    }
}
