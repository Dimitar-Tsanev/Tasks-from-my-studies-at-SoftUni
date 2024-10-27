package entities;

import jakarta.persistence.*;

import java.util.Collections;
import java.util.Set;

@Entity
@Table(name = "teachers")
public class Teacher extends Person{

    @Basic
    private String email;

    @Column(name = "salary_per_hour")
    private Double salaryPerHour;

    @OneToMany(mappedBy = "teacher", targetEntity = Course.class)
    private Set<Course> courses;

    public Teacher () {
    }

    public String getEmail () {
        return email;
    }

    public void setEmail ( String email ) {
        this.email = email;
    }

    public Double getSalaryPerHour () {
        return salaryPerHour;
    }

    public void setSalaryPerHour ( Double salaryPerHour ) {
        this.salaryPerHour = salaryPerHour;
    }

    public Set<Course> getCourses () {
        return Collections.unmodifiableSet ( courses );
    }

    public void addCourses ( Course course ) {
        this.courses.add ( course );
    }
}
