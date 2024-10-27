import entities.Address;
import entities.Employee;
import entities.Project;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.List;



public class Main {
    private static final BufferedReader READER = new BufferedReader ( new InputStreamReader ( System.in ) );

    private static final EntityManager ENTITY_MANAGER = getEntityManager ();



    public static void main ( String[] args ) throws IOException {

        ENTITY_MANAGER.getTransaction ().begin ();

        changeCasingTownNameLengthMoreThenFive ();
        containsEmployee ();
        getEmployeesWithSalaryMoreThan50000();
        getEmployeesFromResearchAndDevelopment ();
        setNewAddressOnEmployee ();
        getAddressWithEmployeeCount ();
        getEmployeesProjects ();
        getLatestProjects();
        increaseSalariesOfDepartments ();
        findEmployeeByFirstname();
        getDepartmentMaximumSalary();
        deleteTownsAndItsAddress();

       ENTITY_MANAGER.getTransaction ().commit ();
       ENTITY_MANAGER.close ();
    }

    private static EntityManager getEntityManager () {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory ( "soft_uni" );

        return entityManagerFactory.createEntityManager ();
    }

    //2.Change casing
    private static void changeCasingTownNameLengthMoreThenFive(){
        ENTITY_MANAGER.createQuery ( "UPDATE town SET name = UPPER(name) WHERE CHAR_LENGTH(name > 5 " )
                .executeUpdate ();

        /*  method 2 -> ENTITY_MANAGER.createQuery ( "FROM Town WHERE LENGTH(name) > 5", Town.class )
                .getResultList ()
                .forEach ( t ->{
                    t.setName ( t.getName ().toUpperCase ());
                     ENTITY_MANAGER.persist ( t );
                });*/


    }

    //3.Contains Employee
    private static void containsEmployee() throws IOException {
        String fullName = READER.readLine ();
        String firstName = fullName.split ( " " )[0];
        String lastName = fullName.split ( " " )[1];

        List<Employee> employees = ENTITY_MANAGER.createQuery ( "FROM Employee WHERE firstName = :firstName AND lastName = : lastName", Employee.class)
                .setParameter ( "firstName", firstName )
                .setParameter ( "lastName", lastName )
                .getResultList ();

        printYesNo ( !employees.isEmpty () );

    }

    private static void printYesNo(boolean isPresent){
        System.out.println ( isPresent ? "Yes" : "No" );
    }

    //4.Employees with a Salary Over 50 000
    private static void getEmployeesWithSalaryMoreThan50000(){
        List<Employee> employees= ENTITY_MANAGER.createQuery ( "FROM Employee WHERE salary > 50000", Employee.class ).getResultList ( );

        employees.stream ().map ( Employee::getFirstName ).forEach ( System.out::println );
    }

    //5.Employees from Department
    private static void getEmployeesFromResearchAndDevelopment(){
        List<Employee> employees = ENTITY_MANAGER.createQuery (
                "FROM Employee WHERE department.name = 'Research and Development' ORDER BY salary, id", Employee.class
        ).getResultList ( );

        employees.forEach ( e -> System.out.printf ( "%s %s from %s - %.2f%n",
                e.getFirstName (),
                e.getLastName (),
                e.getDepartment ().getName (),
                e.getSalary () ) );
    }

    //6.Adding a New Address and Updating the Employee
    private static void setNewAddressOnEmployee() throws IOException {
        Address address = new Address ();
        address.setText ( "Vitoshka 15" );
        ENTITY_MANAGER.persist ( address );

        String lastName = READER.readLine ();

        Employee employee = ENTITY_MANAGER.createQuery ( "FROM Employee WHERE lastName = :lastName", Employee.class )
                .setParameter ( "lastName", lastName )
                .getSingleResult ();

       employee.setAddress ( address );
       ENTITY_MANAGER.persist ( employee );
    }

    //7.Addresses with Employee Count
    private static void getAddressWithEmployeeCount(){
        ENTITY_MANAGER.createQuery ( "FROM Address ORDER BY employees.size DESC", Address.class )
                .setMaxResults ( 10 )
                .getResultList ()
                .forEach ( a -> System.out.printf ( "%s %s - %d employees%n",
                        a.getText (), a.getTown () == null ? "null": a.getTown ().getName () , a.getEmployees().size()));

    }

    //8.Get Employees with Project
    private static void getEmployeesProjects() throws IOException {
        int employeeID = Integer.parseInt ( READER.readLine ());
        Employee employee = ENTITY_MANAGER.createQuery ( "FROM Employee WHERE id = :id",Employee.class ).setParameter ( "id", employeeID ).getSingleResult ();

        System.out.printf ( "%s %s - %s%n", employee.getFirstName (), employee.getLastName (), employee.getJobTitle () );
        employee.getProjects ().stream( ).map ( Project::getName ).sorted ().forEach ( System.out::println );
    }

    //9.Find the Latest 10 Projects
    private static void getLatestProjects(){
        ENTITY_MANAGER.createQuery ( "FROM Project ORDER BY startDate DESC", Project.class).setMaxResults ( 10 )
                .getResultList ()
                .forEach ( p -> System.out.printf ( "Project name: %s%n" +
                        "\tProject Description: %s%n" +
                        " \tProject Start Date:%s" +
                        " \tProject End Date: %s%n",
                        p.getName (), p.getDescription (), p.getStartDate (), p.getEndDate () == null ? "null" : p.getEndDate ()));
    }

    //10.Increase Salaries
    private static void increaseSalariesOfDepartments(){
        ENTITY_MANAGER.createQuery ( "FROM Employee WHERE department.name " +
                        "IN ('Engineering', 'Tool Design', 'Marketing','Information Services')",Employee.class)
                .getResultList ()
                .forEach ( e -> {
                    e.setSalary ( e.getSalary ().multiply ( BigDecimal.valueOf ( 1.12 ) ) );
            ENTITY_MANAGER.persist ( e );
            System.out.printf ( "%s %s (%.2f)%n", e.getFirstName (),e.getLastName (), e.getSalary () );
        });
    }

    //11.Find Employees by First Name
    private static void findEmployeeByFirstname() throws IOException {
        String pattern = READER.readLine ();
        pattern = pattern.concat ( "%" );
        ENTITY_MANAGER.createQuery ( "FROM Employee WHERE firstName LIKE :pattern", Employee.class )
                .setParameter ( "pattern", pattern )
                .getResultList ()
                .forEach ( e ->
                        System.out.printf ( "%s %s - %s - ($%.2f)%n",
                                e.getFirstName (),
                                e.getLastName (),
                                e.getJobTitle (),
                                e.getSalary () ) );
    }

    //12.Employees Maximum Salaries
    private static void getDepartmentMaximumSalary(){
        List<Object[]> results = ENTITY_MANAGER.createQuery ( "SELECT d.name, MAX(e.salary) FROM Department d JOIN d.employees e GROUP BY d.name HAVING MAX(e.salary) NOT BETWEEN 30000 and 70000",Object[].class).getResultList ();

        results.forEach ( r -> System.out.println ( r[0] + " " + r[1]) );
    }

    //13.Remove Towns
    private static void deleteTownsAndItsAddress() throws IOException {
        String townToDelete = READER.readLine ();

        Town town = ENTITY_MANAGER.createQuery ( "FROM Town WHERE name = :townName", Town.class )
                .setParameter ( "townName", townToDelete )
                .getSingleResult ();

        List<Address> addressesInTown = ENTITY_MANAGER.createQuery ( "FROM Address WHERE town_id = :townId", Address.class )
                .setParameter ( "townId", town.getId () )
                .getResultList ();

        ENTITY_MANAGER.createQuery ( "FROM Employee WHERE address.town.name = :townName", Employee.class )
                .setParameter ( "townName", townToDelete )
                .getResultList ()
                .forEach ( e -> {
                    e.setAddress ( null );
                    ENTITY_MANAGER.persist ( e );
                });

        int addressesCount = addressesInTown.size ();

        addressesInTown.forEach ( ENTITY_MANAGER::remove );

        ENTITY_MANAGER.remove ( town );

        System.out.printf ( "%d address in %s deleted", addressesCount, townToDelete );

    }
}
