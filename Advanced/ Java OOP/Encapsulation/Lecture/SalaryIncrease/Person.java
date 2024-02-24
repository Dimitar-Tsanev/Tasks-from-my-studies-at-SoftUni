package SalaryIncrease;

class Person {
    private static final String TEMPLATE = "%s %s gets %f leva";
    private String firstName;
    private String lastName;
    private int age;
    private double salary;
    public Person (String firstName, String lastName, int age, double salary){
        this.setFirstName ( firstName );
        this.setLastName ( lastName );
        this.setAge ( age );
        this.setSalary ( salary );

    }
    private void setFirstName(String firstName){
        this.firstName = firstName;
    }

    private void setLastName ( String lastName ) {
        this.lastName = lastName;
    }

    private void setAge ( int age ) {
        this.age = age;
    }

    private void setSalary ( double salary ) {
        this.salary = salary;
    }

    private String getFirstName () {
        return this.firstName;
    }

    private String getLastName () {
        return this.lastName;
    }

    private int getAge () {
        return this.age;
    }

    private double getSalary () {
        return this.salary;
    }
    public void increaseSalary (double bonus){
        if (getAge () < 30 ){
            bonus /=2;
        }
        setSalary ( getSalary () * (1 + bonus/100));
    }
    @Override
    public String toString(){
        return String.format ( TEMPLATE,getFirstName (),getLastName (),getSalary () );
    }
}
