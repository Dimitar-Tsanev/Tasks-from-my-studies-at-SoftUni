package employees.entities.DTOs;

import java.math.BigDecimal;

//1.Simple Mapping
public class SimpleEmployeeDTO {

    private String firstName;

    private String lastName;

    private BigDecimal salary;

    public SimpleEmployeeDTO () {
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

    @Override
    public String toString () {
        return firstName + " " +  lastName + ' ' + salary;
    }
}
