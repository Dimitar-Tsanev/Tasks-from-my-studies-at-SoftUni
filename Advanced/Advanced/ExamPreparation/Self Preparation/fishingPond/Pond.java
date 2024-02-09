package fishingPond;

import java.util.ArrayList;
import java.util.List;

class Pond {
    private int capacity;
    private List<Fish> fishes;

    public Pond ( int capacity ) {
        this.capacity = capacity;
        this.fishes = new ArrayList<> ( );

    }

    public void addFish ( Fish fish ) {
        if ( capacity > this.fishes.size ( ) ) {
            this.fishes.add ( fish );
        }
    }

    public boolean removeFish ( String species ) {
        Fish fish = getFish ( species );
        if ( fish != null ) {
            return this.fishes.remove ( fish );

        }
        return false;
    }

    public Fish getOldestFish () {
        return fishes.stream ( )
                .max ( ( f1, f2 ) -> f1.getAge ( ) > f2.getAge ( ) ? 1 : f1 == f2 ? 0 : -1 )
                .orElse ( null );

    }

    public Fish getFish ( String species ) {
        return fishes.stream ( )
                .filter ( fish -> fish.getSpecies ( ).equals ( species ) )
                .findFirst ( )
                .orElse ( null );

    }
    public int getCount (){
        return this.fishes.size ();

    }
    public int getVacancies(){
        return capacity - this.fishes.size ();

    }
    public String report(){
        StringBuilder report = new StringBuilder ( "Fishes in the pond:" );
        report.append ( System.lineSeparator () );
        fishes.forEach ( f ->{
            report.append ( f );
            report.append ( System.lineSeparator () );
        }  );
        return report.toString ();
    }
}
