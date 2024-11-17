package bookshop.service;

import bookshop.model.entity.Author;

import java.io.IOException;
import java.util.List;

public interface AuthorService {
    void seedAuthors() throws IOException;

    Author getRandomAuthor();

    List<String> getAllAuthorsOrderByCountOfTheirBooks();

    List<String> findAuthorsFirstNameEndWith (String firstNameEnd);

    List<String> getAuthorsTotalBooksCopies();

    int getAuthorBooksCount ( String authorName );
}
