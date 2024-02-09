package StackIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class CustomStack<T> implements Iterable<T> {
    private List<T> stack;

    public CustomStack () {
        this.stack = new ArrayList<> ( );

    }

    public final void push ( T[] numbers ) {
        stack.addAll ( Arrays.asList ( numbers ) );

    }

    public void pop () {
        if ( stack.isEmpty ( ) ) {
            System.out.println ( "No elements" );

        } else {
            this.stack.remove ( stack.size ( ) - 1 );

        }
    }
    public int size() {
        return this.stack.size ();
    }

    @Override
    public Iterator<T> iterator () {
        return new StackIterator( );
    }

    private final class StackIterator implements Iterator<T> {

        private int count = stack.size ( ) - 1;

        @Override
        public boolean hasNext () {
            return count >= 0;
        }

        @Override
        public T next () {
            return stack.get ( count-- );
        }
    }
}
