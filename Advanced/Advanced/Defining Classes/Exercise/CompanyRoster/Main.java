package CompanyRoster;

import java.util.*;

public class Main {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        List<Department> departments = new ArrayList<> ( );

        int linesNumber = Integer.parseInt ( scanner.nextLine ( ) );

        for ( int i = 0 ; i < linesNumber ; i++ ) {
            String[] employeeData = scanner.nextLine ( ).split ( "\\s+" );

            Employee employee = getEmployee ( employeeData );

            Department employeeDepartment = employee.getDepartment ( );

            if ( !departments.contains ( employeeDepartment ) ) {
                departments.add ( employeeDepartment );

            }
            int indexOfDepartment = departments.indexOf ( employeeDepartment );
            departments.get ( indexOfDepartment ).addEmployee ( employee );

        }
        Department bestSalary = getBestAverageSalaryDepartment ( departments );
        System.out.println ( "Highest Average Salary: " + bestSalary.getDepartmentName ( ) );

        Comparator<Employee> salarySort = ( x1, x2 ) -> Double.compare ( x2.getSalary ( ), x1.getSalary ( ) );

        bestSalary.getEmployees ( ).sort ( salarySort );
        bestSalary.getEmployees ( ).forEach ( System.out::println );

    }

    private static Department getBestAverageSalaryDepartment ( List<Department> departments ) {
        Department best = new Department ( );
        for ( Department department : departments ) {
            department.getDepartmentAverageSalary ();

            if ( best.getAverageSalary ( ) < department.getAverageSalary ( ) ) {
                best = department;

            }
        }
        return best;
    }

    private static Employee getEmployee ( String[] employeeData ) {
        Employee employee;

        String name = employeeData[0];
        double salary = Double.parseDouble ( employeeData[1] );
        String position = employeeData[2];
        String department = employeeData[3];
        String email;
        int age;

        if ( employeeData.length == 5 ) {
            if ( employeeData[4].contains ( "@" ) ) {
                email = employeeData[4];
                employee = new Employee ( name, salary, position, department, email );

            } else {
                age = Integer.parseInt ( employeeData[4] );
                employee = new Employee ( name, salary, position, department, age );

            }
        } else if ( employeeData.length == 6 ) {
            email = employeeData[4];
            age = Integer.parseInt ( employeeData[5] );
            employee = new Employee ( name, salary, position, department, email, age );

        } else {
            employee = new Employee ( name, salary, position, department );

        }
        return employee;
    }
}
