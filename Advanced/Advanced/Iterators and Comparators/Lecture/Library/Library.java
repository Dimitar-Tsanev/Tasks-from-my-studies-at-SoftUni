package Library;

import java.util.Iterator;


public class Library <Book> implements  Iterable<Book> {
    private Book[] books;

    public Library( Book... books ){
        this.books =books;
    }
    public Iterator<Book> iterator (){
        return new LiberIterator();
    }
    private final class LiberIterator implements Iterator<Book>{
        private int counter = 0;
        public boolean hasNext(){
            return this.counter < books.length;
        }
        public Book next() {
            return books[counter++];

        }
    }
}
