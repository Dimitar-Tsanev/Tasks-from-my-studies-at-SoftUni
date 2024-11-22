package employees.entities.DTOs;

import java.util.Set;

public class ManagerDTO {

    private String firstName;

    private String lastName;

    private Set<SimpleEmployeeDTO> managedEmployees;

    public ManagerDTO() {}

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

    public Set<SimpleEmployeeDTO> getEmployees () {
        return managedEmployees;
    }

    public void setEmployees ( Set<SimpleEmployeeDTO> employees ) {
        this.managedEmployees = employees;
    }

}
