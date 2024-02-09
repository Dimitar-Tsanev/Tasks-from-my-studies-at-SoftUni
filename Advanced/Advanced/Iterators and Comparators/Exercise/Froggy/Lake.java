package Froggy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class Lake implements Iterable<Integer>{
    private List<Integer> data;

    public Lake ( Integer... numbers ) {
        this.data = new ArrayList<> ();
        Collections.addAll ( data, numbers );
    }
    public int size(){
        return data.size ();
    }
    public Iterator<Integer> iterator () {
        return new Frog ();
    }
    private class Frog implements Iterator<Integer>{
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
        public Integer next () {
            counter += 2;
            return data.get ( counter );
        }
    }
}
