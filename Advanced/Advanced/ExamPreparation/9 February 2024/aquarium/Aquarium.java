package aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    private String name;
    private int capacity;
    private int size;
    private List<Fish> fishInPool;

    public Aquarium ( String name, int capacity, int size ) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new ArrayList<> ();

    }

    public String getName () {
        return this.name;
    }

    public int getCapacity () {
        return this.capacity;
    }

    public int getSize () {
        return this.size;
    }

    public int getFishInPool () {
        return this.fishInPool.size ();
    }
    public void add ( Fish fish) {
        String fishName = fish.getName ();
        if ( findFish ( fishName ) == null && this.capacity > getFishInPool ( ) ) {
            this.fishInPool.add ( fish );
        }
    }

    public boolean remove (String name){
         Fish thisFish = findFish ( name );

         if ( thisFish != null ){
             return fishInPool.remove ( thisFish );
         }
         return false;
    }

    public Fish findFish ( String name){
       return fishInPool.stream ()
                .filter ( f -> f.getName ().equals ( name ) )
                .findFirst ().orElse ( null );
    }
    public String report (){
        StringBuilder result = new StringBuilder (String.format ("Aquarium: %s ^ Size: %d%n", this.name, this.size));

        for ( Fish fish: fishInPool ){
            result.append ( fish );
        }
        return result.toString ();
    }
}
