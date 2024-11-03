package bookshop.service.interfaces;

import bookshop.data.entities.Book;

import java.util.List;

public interface BookService extends DatabaseSeed {

    List<Book> findBooksReleasedAfter2000();
    List<Book> findBooksByAuthorFullName(String authorFullName);
}
