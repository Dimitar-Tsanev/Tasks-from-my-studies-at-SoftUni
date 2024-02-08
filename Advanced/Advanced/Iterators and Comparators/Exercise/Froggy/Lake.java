package Froggy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Lake <Integer> implements Iterable<Integer>{
    private List<Integer> data;

    @SafeVarargs
    public Lake ( Integer... numbers ) {
        this.data = new ArrayList<> ();
        Collections.addAll ( data, numbers );
    }
    public int size(){
        return data.size ();
    }
    public Iterator<Integer> iterator () {
        return new Frog<>();
    }
    private final class Frog<T> implements Iterator<T>{
        private int counter = -2;
        private boolean breaker = true;
        @Override
        public boolean hasNext () {
            if (counter < data.size () - 2) {
                return counter < data.size ( ) - 2;

            }else if (breaker) {
                counter = -1;
                breaker = false;

            }
            return counter < data.size ( ) - 2;
        }

        @Override
        public T next () {
            counter += 2;
            return (T) data.get ( counter );
        }
    }
}
