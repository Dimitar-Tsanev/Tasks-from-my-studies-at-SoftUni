package bookshop.service;

import bookshop.model.entity.Book;

import java.io.IOException;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear( int year);

    List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);

    List<String> findAllBooksByAgeRestriction( String ageRestriction);

    List<String> findAllBooksByGoldEditionTypeWithLessThan5000Copies();

    List<String> findBooksWithPriceLessThan5AndHigherThan40();

    List<String> findAllBooksNotReleasedInYear(int year);

    List<String> findAllBooksReleasedBefore(String date);

    List<String> findAllBooksTitleContaining(String bookTitle);

    List<String> findAllBooksOfAuthorLastNameEndWith ( String authorLastName);

    int findBooksWithTitleSizeLongerThan(int titleLength);

    String getBookInfoByTitle(String title);

    int increaseBooksCopiesOfBooksReleasedAfter(String date, int copies );

    int deleteBooksWithCopiesLessThan(int copies);


}
