package employees.services;

import employees.entities.DTOs.EmployeeDTO;
import employees.entities.DTOs.ManagerDTO;
import employees.entities.DTOs.SimpleEmployeeDTO;

import java.util.Set;

public interface EmployeeService {

    void seedEmployeesTaskOne ();
    void seedEmployeesTaskTwo ();

    Set<SimpleEmployeeDTO> getAllEmployees();

    int getEmployeesCount();
    int getEmployeesCountTasTwo();

    Set<ManagerDTO> getAllManagers();
    Set<EmployeeDTO> getEmployeesBornBefore ( String date);

}
