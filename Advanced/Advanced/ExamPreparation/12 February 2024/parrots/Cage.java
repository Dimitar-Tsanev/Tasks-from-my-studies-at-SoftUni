package parrots;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private String name;
    private int capacity;
    private List<Parrot> data;

    public Cage ( String name, int capacity ) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<> ( );
    }

    public String getName () {
        return name;
    }

    public int getCapacity () {
        return capacity;
    }

    public void add ( Parrot parrot ) {
        if ( this.capacity > this.data.size ( ) ) {
            this.data.add ( parrot );
        }
    }

    public boolean remove ( String name ) {
        for ( Parrot parrot : this.data ) {
            if ( name.equals ( parrot.getName ( ) ) ) {
                return data.remove ( parrot );
            }
        }
        return false;
    }

    public Parrot sellParrot ( String name ) {
        for ( Parrot parrot : this.data ) {
            if ( name.equals ( parrot.getName ( ) ) ) {
                parrot.setAvailable ( false );

                return parrot;
            }
        }
        return null;
    }

    public List<Parrot> sellParrotBySpecies ( String species ) {
        List<Parrot> toSell = new ArrayList<> ( );

        for ( Parrot parrot : this.data ) {
            if ( species.equals ( parrot.getSpecies ( ) ) ) {
                parrot.setAvailable ( false );
                toSell.add ( parrot );

            }
        }
        return toSell;
    }

    public int count () {
        return this.data.size ( );
    }

    public String report () {
        StringBuilder report = new StringBuilder ();
        report.append ( String.format ( "Parrots available at %s:",this.name ) );
        report.append ( System.lineSeparator () );
        for ( Parrot parrot: data ){
            if(parrot.isAvailable ()) {
                report.append ( parrot );
                report.append ( System.lineSeparator ( ) );
            }
        }
        return report.toString ();
    }
}
