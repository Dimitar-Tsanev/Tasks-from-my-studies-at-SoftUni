package hotel;

import java.util.ArrayList;
import java.util.List;

class Hotel {
    private String name;
    private int capacity;
    private List<Person> roster;

    public Hotel ( String name, int capacity ) {
        this.setName ( name );
        this.setCapacity ( capacity );
        this.roster = new ArrayList<> ();
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public void setCapacity ( int capacity ) {
        this.capacity = capacity;
    }
    public void add(Person person){
        if (capacity > roster.size () ){
            this.roster.add ( person );
        }
    }
    public boolean remove(String name){
        if (this.roster.isEmpty () || name == null){
            return false;
        }
        return this.roster.removeIf ( p-> p.getName ().equals ( name ) );
    }
    public Person getPerson (String name, String hometown){
        if (this.roster.isEmpty () || name == null || hometown == null){
            return null;
        }
        for ( Person person: roster ){
            if(person.getName ().equals ( name ) && person.getHometown ().equals ( hometown )){
                return person;
            }
        }
        return null;
    }
    public int getCount(){
        return this.roster.size ();

    }
    public String getStatistics(){
        String firstLine = String.format ("The people in the hotel %s are:",this.name);

        if( this.roster.isEmpty ()){
            return firstLine;
        }
        StringBuilder report = new StringBuilder ();
        report.append ( System.lineSeparator () );

        roster.forEach ( g-> report.append ( g ).append ( System.lineSeparator () ) );

        return firstLine + report;
    }
}
