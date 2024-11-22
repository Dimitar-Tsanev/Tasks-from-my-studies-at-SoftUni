package employees.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
public class EmployeeTaskOne extends BaseEntity{

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

    public EmployeeTaskOne () {
    }

    public EmployeeTaskOne ( String firstName, String lastName, BigDecimal salary ) {
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
