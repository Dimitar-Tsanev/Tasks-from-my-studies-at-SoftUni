package groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {

    private int  capacity;
    private List<Pet> data;

    public GroomingSalon ( int capacity ) {
        this.capacity = capacity;
        this.data = new ArrayList<> ();

    }
    public void add ( Pet pet ) {
        if ( this.capacity > this.data.size ( ) ) {
          this.data.add ( pet);
        }
    }

    public final boolean remove ( String name ) {
        for ( Pet pet : data ) {
            if ( pet.getName ( ).equals ( name ) ) {
                data.remove ( pet );
                return true;
            }
        }
        return false;
    }

    public final Pet getPet ( String name, String owner ) {
        for ( Pet pet : data ) {
            if ( pet.getName ( ).equals ( name ) && pet.getOwner ( ).equals ( owner ) ) {
                return pet;
            }
        }
        return null;
    }

    public final int getCount () {
        return this.data.size ( );
    }

    public final String getStatistics () {
        String statistic = String.format ( "The grooming salon has the following clients:%n" );
        StringBuilder petListInformation = new StringBuilder ( );
        for ( Pet pet : data ) {
            petListInformation.append ( String.format ( "%s %s%n", pet.getName ( ), pet.getOwner ( ) ) );
        }
        return statistic + petListInformation;
    }
}
