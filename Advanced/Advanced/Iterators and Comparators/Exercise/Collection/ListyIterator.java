package Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

class ListyIterator implements Iterable<String> {
    private List<String> data;
    private int pointer;

    public ListyIterator ( String... elements ) {
        this.data = new ArrayList<> ( Arrays.asList ( elements ) );

        this.pointer = 0;
    }
    public Iterator<String> iterator () {
        return new CustomIterator ( );
    }

    @Override
    public void forEach ( Consumer<? super String> action ) {
        if (data.isEmpty ( ) ){
            System.out.println ("Invalid Operation!" );
        }else{
            Iterable.super.forEach ( action );
        }
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

    private class CustomIterator implements Iterator<String> {
        private int counter = 0;

        public boolean hasNext () {
            return this.counter < data.size ( );
        }

        public String next () {
            return data.get ( counter++ );
        }
    }
}
