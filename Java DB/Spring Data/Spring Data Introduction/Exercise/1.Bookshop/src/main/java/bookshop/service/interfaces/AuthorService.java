package bookshop.service.interfaces;

import bookshop.data.entities.Author;

import java.util.List;

public interface AuthorService extends DatabaseSeed {
    Author getRandomAuthor();

    List<Author> getAuthorsWithBooksBefore1990();
    List<Author> getAllAuthorOrderedByBooksCount();
}
