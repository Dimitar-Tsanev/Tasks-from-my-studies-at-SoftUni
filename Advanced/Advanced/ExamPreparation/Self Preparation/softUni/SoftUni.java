package softUni;

import java.util.ArrayList;
import java.util.List;

class SoftUni {
    private int capacity;

    private List<Student> data;

    public SoftUni ( int capacity ) {
        this.capacity = capacity;
        this.data = new ArrayList<> ( );

    }

    public int getCapacity () {
        return capacity;
    }

    public int getCount () {
        return this.data.size ( );
    }

    public String insert ( Student student ) {
        if ( getCapacity ( ) <= getCount ( ) ) {
            return "The hall is full.";

        }
        if ( data.contains ( student ) ) {
            return "Student is already in the hall.";

        }
        this.data.add ( student );

        return String.format ( "Added student %s %s.",
                student.getFirstName ( ),
                student.getLastName ( ) );

    }
    public String remove (Student student){
        if ( this.data.contains ( student ) ){
            this.data.remove ( student );
            return String.format ( "Removed student %s %s.",
                    student.getFirstName (),
                    student.getLastName () );

        }
        return "Student not found.";
    }

    public Student getStudent ( String firstName, String lastName ) {
        return data.stream ()
                .filter ( s->s.getFirstName ().equals ( firstName ) &&
                        s.getLastName ().equals ( lastName ))
                .findFirst ()
                .orElse ( null);
    }
    public String getStatistics(){

        StringBuilder report = new StringBuilder (String.format ( "Hall size: %d%n",getCount () ));
        this.data.forEach ( s-> report.append ( s ).append ( System.lineSeparator () ) );

        return report.toString ();
    }
}
