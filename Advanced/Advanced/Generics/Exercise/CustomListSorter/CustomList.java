package CustomListSorter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class CustomList <T extends Comparable<T>> {

    private List<T> elements;

    public CustomList () {
        this.elements = new ArrayList<> ( );

    }

    public void add ( T element ) {
        this.elements.add ( element );

    }

    public T remove ( int index ) {
        return this.elements.remove ( index );

    }

    public boolean contains ( T element ) {
        return this.elements.contains ( element );

    }

    public void swap ( int index1, int index2 ) {
        T swapper = this.elements.get ( index1 );
        this.elements.set ( index1, this.elements.get ( index2 ) );
        this.elements.set ( index2, swapper );

    }

    public int countGreaterThan ( T element ) {
        int count = 0;
        for ( T entity: elements ) {
            if ( entity.compareTo ( element ) > 0 ) {
                count++;

            }
        }
        return count;
    }
    public T getMax() {
        return this.elements.stream( ).max ( Comparator.naturalOrder () ).get ();

    }
    public T getMin() {
        return this.elements.stream( ).min ( Comparator.naturalOrder () ).get ();

    }
    public int size(){
        return this.elements.size ();

    }
    public T get (int index){
        return this.elements.get ( index );
    }

    public CustomList<T> sort () {
        CustomList<T> sorted = new CustomList<> ();
        List <T> sort = this.elements.stream ().sorted (Comparator.naturalOrder ()).collect( Collectors.toList());
        sort.forEach ( sorted::add );
        return sorted;
    }
}
