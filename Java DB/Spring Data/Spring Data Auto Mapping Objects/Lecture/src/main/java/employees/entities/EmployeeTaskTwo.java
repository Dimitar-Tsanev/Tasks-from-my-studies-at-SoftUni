package employees.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employees_task_two")
public class EmployeeTaskTwo extends BaseEntity{
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false)
    private BigDecimal salary;

    @Basic
    private LocalDate birthDate;

    @Basic
    private String address;

    @ManyToOne
    @JoinColumn(name = "manager_id", referencedColumnName = "id")
    private EmployeeTaskTwo manager;

    @OneToMany(mappedBy = "manager",targetEntity = EmployeeTaskTwo.class)
    private Set<EmployeeTaskTwo> managedEmployees;


    public EmployeeTaskTwo getManager () {
        return manager;
    }

    public void setManager ( EmployeeTaskTwo manager ) {
        this.manager = manager;
    }

    public Set<EmployeeTaskTwo> getManagedEmployees () {
        return managedEmployees;
    }

    public void setManagedEmployees ( Set<EmployeeTaskTwo> managedEmployees ) {
        this.managedEmployees = managedEmployees;
    }

    public EmployeeTaskTwo () {
        managedEmployees = new HashSet<> ();
    }

    public EmployeeTaskTwo ( String firstName, String lastName, BigDecimal salary ) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public String getFirstName () {
        return firstName;
    }

    public void setFirstName ( String firstName ) {
        this.firstName = firstName;
    }

    public String getLastName () {
        return lastName;
    }

    public void setLastName ( String lastName ) {
        this.lastName = lastName;
    }

    public BigDecimal getSalary () {
        return salary;
    }

    public void setSalary ( BigDecimal salary ) {
        this.salary = salary;
    }

    public LocalDate getBirthDate () {
        return birthDate;
    }

    public void setBirthDate ( LocalDate birthDate ) {
        this.birthDate = birthDate;
    }

    public String getAddress () {
        return address;
    }

    public void setAddress ( String address ) {
        this.address = address;
    }

}
