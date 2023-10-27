package OpinionPoll;

public class Person {
    private String name;
    private int years;
    public Person (String name, int years){
        this.name = name;
        this.years = years;
    }
    public int getYears(){
        return years;
    }
    public String getInformation(){
        return String.format ( "%s - %d", name, years );
    }
}
