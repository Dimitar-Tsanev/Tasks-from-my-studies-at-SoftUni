package GenericSwapMethodStrings;

import java.util.ArrayList;
import java.util.List;

public class Boxes<T> {

    private List <T> boxes;

    public Boxes () {
        this.boxes = new ArrayList<> ();

    }
    public void add (T element){
        this.boxes.add ( element );
    }
    public void swap (int index1, int index2){
        if (isValid(index1,index2) && index1 != index2 ) {
            T swapper = this.boxes.get ( index1 );
            this.boxes.set ( index1, this.boxes.get ( index2 ) );
            this.boxes.set ( index2, swapper );
        }
    }

    private boolean isValid ( int index1, int index2 ) {
        return index2 >=0 && index2 < this.boxes.size ( ) && index1 >=0 && index1 < this.boxes.size ( );
    }

    @Override
    public String toString () {
        StringBuilder result = new StringBuilder ();

        this.boxes.forEach ( b -> {
            result.append ( b );
            result.append ( System.lineSeparator () );
        });
        return result.toString ();
    }
}
