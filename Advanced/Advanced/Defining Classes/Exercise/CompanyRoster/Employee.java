package CompanyRoster;

class Employee {
    private String name;
    private double salary;
    private String position;
    private Department department;

    private String email;
    private int age;

    public Employee (String name, double salary, String position, String department ){
        this (name, salary,position, department, -1 );

    }

    public Employee ( String name, double salary, String position, String department, int age ){
        this (name, salary, position,department,"n/a",  age);


    }
    public Employee (String name, double salary, String position, String department,String email ){
        this (name, salary, position, department, email, -1);

    }
    public Employee ( String name, double salary, String position, String department, String email, int age ) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = new Department ( department );
        this.email = email;
        this.age = age;

    }

    public double getSalary () {
        return this.salary;

    }

    @Override
    public String toString () {
        return String.format ( "%s %.2f %s %d", this.name, this.salary, this.email, this.age);
    }

    public Department getDepartment () {
        return department;
    }
}
