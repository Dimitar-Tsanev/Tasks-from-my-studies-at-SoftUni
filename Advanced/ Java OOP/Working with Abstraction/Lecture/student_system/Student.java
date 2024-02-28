package student_system;

class Student {
    private String name;
    private int age;
    private double grade;
    private String commentary;

    public Student(String name, int age, double grade) {
        this.setName ( name );
        this.setAge ( age );
        this.setGrade ( grade );
        this.setCommentary ();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getGrade() {
        return this.grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    private void setCommentary (){
        String commentary;

        if (getGrade () >= 5.00) {
            commentary = "Excellent student";
        }
        else if (getGrade () >= 3.50) {
            commentary = "Average student";
        }
        else {
            commentary = "Very nice person";
        }

        this.commentary =  commentary;
    }
    public String getCommentary () {
        return commentary;
    }
}
