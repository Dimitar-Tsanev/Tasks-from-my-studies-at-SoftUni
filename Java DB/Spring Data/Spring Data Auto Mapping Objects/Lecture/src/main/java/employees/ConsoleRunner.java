package employees;

import employees.services.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private final EmployeeService employeeService;

    public ConsoleRunner(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void run ( String... args ) throws Exception {
        if( employeeService.getEmployeesCount ( ) == 0 ){
            employeeService.seedEmployeesTaskOne ();

        }
        if( employeeService.getEmployeesCountTasTwo ( ) == 0 ){
            employeeService.seedEmployeesTaskTwo ();

        }

        //1.Simple Mapping
        employeeService.getAllEmployees ().forEach ( System.out::println );

        //2.Advanced Mapping
        employeeService.getAllManagers ().forEach ( m -> {
            System.out.printf ( "%s %s | Employees: %d%n", m.getFirstName (), m.getLastName (), m.getEmployees ().size () );
            m.getEmployees ().forEach ( e -> System.out.printf ("   - %s%n", e.toString ()) );
        });

        //3.Projection
        employeeService.getEmployeesBornBefore ("01-01-1990"  ).forEach ( System.out::println );
    }
}
