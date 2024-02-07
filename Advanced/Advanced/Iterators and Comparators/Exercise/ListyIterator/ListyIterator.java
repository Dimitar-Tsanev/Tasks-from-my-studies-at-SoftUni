package ListyIterator;

import java.util.*;

public class ListyIterator<String> implements Iterable<String> {
    private List<String> data;
    private int pointer;

    @SafeVarargs
    public ListyIterator ( String... elements ) {

        this.data = new ArrayList<> ( Arrays.asList ( elements ) );

        this.pointer = 0;
    }
    public Iterator<String> iterator () {
        return new CustomIterator<> ( );
    }
    public boolean hasNext() {
        return this.pointer < this.data.size() - 1;
    }

    public boolean move () {
        if ( this.hasNext () ) {
            this.pointer++;
            return true;
        }
        return false;
    }
    public void print () {
        System.out.println ( !data.isEmpty ( ) ? data.get ( pointer ) : "Invalid Operation!" );
    }

    private final class CustomIterator<String> implements Iterator<String> {
        private int counter = 0;

        public boolean hasNext () {
            return this.counter < data.size ( );
        }

        public String next () {
            return (String) data.get ( counter++ );
        }

    }
}
