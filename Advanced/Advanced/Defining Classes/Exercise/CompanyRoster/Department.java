package CompanyRoster;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Department {
    private String departmentName;
    private List<Employee> employees;

    private double averageSalary;

    public Department(){
        this.departmentName ="";
        this.employees = new ArrayList<> ();
    }

    public Department(String departmentName){
        this.departmentName = departmentName;
        this.employees = new ArrayList<> ();

    }
    public void addEmployee (Employee employee){
        this.employees.add ( employee );

    }

    public String getDepartmentName () {
        return this.departmentName;
    }
    public List<Employee> getEmployees () {
        return employees;
    }

    @Override
    public boolean equals ( Object o ) {
        if ( this == o ) return true;
        if ( o == null || getClass ( ) != o.getClass ( ) ) return false;
        Department that = (Department) o;
        return Objects.equals ( departmentName, that.departmentName );
    }

    @Override
    public int hashCode () {
        return Objects.hash ( departmentName );
    }

    public double getDepartmentAverageSalary (Department department){
        double salary = 0.0;
        for ( Employee employee: department.getEmployees ( ) ){
            salary += employee.getSalary ();
        }
        salary = salary / department.getEmployees ().size ();
        return salary;
    }

    public void setAverageSalary ( double averageSalary ) {
        this.averageSalary = averageSalary;
    }

    public double getAverageSalary () {
        return averageSalary;
    }
}
