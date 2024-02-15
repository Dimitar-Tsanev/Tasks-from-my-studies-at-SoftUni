package shelter;

import java.util.ArrayList;
import java.util.List;

class Shelter {
    private int capacity;
    private List<Animal> data;

    public Shelter ( int capacity ) {
        this.setCapacity ( capacity );
        this.data = new ArrayList<> ();
    }

    public void setCapacity ( int capacity ) {
        this.capacity = capacity;
    }

    public void add ( Animal animal ) {
        if ( capacity > this.data.size ( ) ) {
            this.data.add ( animal );
        }
    }

    public boolean remove ( String name ) {
        if ( name != null && !this.data.isEmpty () ) {
            return this.data.removeIf ( a -> a.getName ( ).equals ( name ) );
        }
        return false;
    }

    public Animal getAnimal ( String name, String caretaker ) {
        if ( name != null && caretaker != null && !this.data.isEmpty () ) {
            for ( Animal animal: this.data ){
                if (animal.getName ().equals ( name ) && animal.getCaretaker ().equals ( caretaker )){
                    return animal;
                }
            }
        }

        return null;
    }

    public Animal getOldestAnimal () {
        if (!this.data.isEmpty ()) {
            int maxAge = Integer.MIN_VALUE;
            Animal oldest = this.data.get ( 0 );

            for ( Animal animal : this.data ) {
                if ( maxAge < animal.getAge ( ) ) {
                    maxAge = animal.getAge ( );
                    oldest = animal;

                }
            }
            return oldest;
        }
        return null;
    }

    public int getCount () {
        return this.data.size ( );
    }

    public String getStatistics () {
        String firstLine = "The shelter has the following animals:";
        if ( this.data.isEmpty ( ) ) {
            return firstLine;

        }
        StringBuilder allAnimals = new StringBuilder ( );

        allAnimals.append ( System.lineSeparator ( ) );

        data.forEach ( e -> allAnimals.append ( e.getName ( ) )
                .append ( " " )
                .append ( e.getCaretaker ( ) )
                .append ( System.lineSeparator ( ) ) );

        return firstLine + allAnimals;
    }
}
