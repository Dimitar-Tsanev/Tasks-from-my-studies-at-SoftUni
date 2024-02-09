package BookComparator;

import java.util.Comparator;

class BookComparator implements Comparator<Book> {


    @Override
    public int compare ( Book firstBook, Book secondBook ) {
        if(firstBook.getTitle ().compareTo ( secondBook.getTitle () ) == 0 ){
            if ( firstBook.getYear () > secondBook.getYear ( ) ){
                return 1;

            } else if ( firstBook.getYear () == secondBook.getYear ( ) ) {
                return 0;

            }
            return -1;

        }
        return firstBook.getTitle ().compareTo (secondBook.getTitle ( ) );
    }
}
