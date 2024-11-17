package bookshop;

import bookshop.model.entity.Book;
import bookshop.service.AuthorService;
import bookshop.service.BookService;
import bookshop.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private static final BufferedReader READER = new BufferedReader ( new InputStreamReader ( System.in ) );

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;


    public CommandLineRunnerImpl ( CategoryService categoryService, AuthorService authorService, BookService bookService ) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run ( String... args ) throws Exception {
        seedData ( );

        //printAllBooksAfterYear(2000);
        //printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(1990);
        //printAllAuthorsAndNumberOfTheirBooks();
        //printALlBooksByAuthorNameOrderByReleaseDate("George", "Powell");

        //getBooksByAgeRestriction();
        //getGoldenBooksWithLessThan5000Copies ();
        //getBooksWithPriceLessThan5AndHigherThan40 ();
        //getBooksNotReleasedInYear();
        //getBooksReleasedBefore();
        //getAuthorsFirstNameEndWith();
        //getBooksByTitleContains ();
        //getBooksTitlesOfAuthorLastNameStartWith ();
        //getBooksCountWithTitlesLongerThan();
        //getAuthorsAllBooksCopies ( );
        //getBookTitleEditionTypeAgeRestrictionAndPriceByBookTitle ();
        //increaseBooksCopiesReleaseAfter ();
        //deleteBooksWithLessThanCopies ();
        //getAuthorsAllBooks ();
    }

    //1.Books Titles by Age Restriction
    private void getBooksByAgeRestriction () throws IOException {
        String ageRestriction = READER.readLine ( );

        bookService.findAllBooksByAgeRestriction ( ageRestriction )
                .forEach ( System.out::println );
    }

    //2.Golden Books
    private void getGoldenBooksWithLessThan5000Copies () {
        bookService.findAllBooksByGoldEditionTypeWithLessThan5000Copies ( )
                .forEach ( System.out::println );
    }

    //3.Books by Price
    private void getBooksWithPriceLessThan5AndHigherThan40 () {
        bookService.findBooksWithPriceLessThan5AndHigherThan40 ( )
                .forEach ( System.out::println );
        ;
    }

    //4.Not Released Books
    private void getBooksNotReleasedInYear () throws IOException {
        int year = Integer.parseInt ( READER.readLine ( ) );

        bookService.findAllBooksNotReleasedInYear ( year )
                .forEach ( System.out::println );
    }

    //5.Books Released Before Date
    private void getBooksReleasedBefore () throws IOException {
        String date = READER.readLine ( );

        bookService.findAllBooksReleasedBefore ( date )
                .forEach ( System.out::println );
    }

    //6.Authors Search
    private void getAuthorsFirstNameEndWith () throws IOException {
        String firstNameEnd = READER.readLine ( );

        authorService.findAuthorsFirstNameEndWith ( firstNameEnd )
                .forEach ( System.out::println );
    }

    //7.Books Search
    private void getBooksByTitleContains () throws IOException {
        String bookTitle = READER.readLine ( );

        bookService.findAllBooksTitleContaining ( bookTitle )
                .forEach ( System.out::println );
    }

    //8.Book Titles Search
    private void getBooksTitlesOfAuthorLastNameStartWith () throws IOException {
        String authorLastName = READER.readLine ( );

        bookService.findAllBooksOfAuthorLastNameEndWith ( authorLastName )
                .forEach ( System.out::println );
    }

    //9.Count Books
    private void getBooksCountWithTitlesLongerThan () throws IOException {
        int titleLength = Integer.parseInt ( READER.readLine ( ) );

        System.out.println ( bookService.findBooksWithTitleSizeLongerThan ( titleLength ) );
    }

    //10.Total Book Copies
    private void getAuthorsAllBooksCopies () {
        authorService.getAuthorsTotalBooksCopies()
                .forEach ( System.out::println );
    }

    //11.Reduced Book
    private void getBookTitleEditionTypeAgeRestrictionAndPriceByBookTitle () throws IOException {
        String title = READER.readLine ( );

        System.out.println ( bookService.getBookInfoByTitle(title) );
    }

    //12. Increase Book Copies
    private void increaseBooksCopiesReleaseAfter() throws IOException {
        String date = READER.readLine ( );
        int copies = Integer.parseInt ( READER.readLine ( ) );

        System.out.println ( bookService.increaseBooksCopiesOfBooksReleasedAfter(date, copies ) );
    }

    //13.Remove Books
    private void deleteBooksWithLessThanCopies () throws IOException {
        int copies = Integer.parseInt ( READER.readLine ( ) );

        System.out.println ( bookService.deleteBooksWithCopiesLessThan ( copies ));
    }

    //14.Stored Procedure
    private void getAuthorsAllBooks () throws IOException {
        String authorName = READER.readLine ( );

        System.out.println (authorService.getAuthorBooksCount (authorName) );
    }

    private void printALlBooksByAuthorNameOrderByReleaseDate ( String firstName, String lastName ) {
        bookService
                .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate ( firstName, lastName )
                .forEach ( System.out::println );
    }

    private void printAllAuthorsAndNumberOfTheirBooks () {
        authorService
                .getAllAuthorsOrderByCountOfTheirBooks ( )
                .forEach ( System.out::println );
    }

    private void printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear ( int year ) {
        bookService
                .findAllAuthorsWithBooksWithReleaseDateBeforeYear ( year )
                .forEach ( System.out::println );
    }

    private void printAllBooksAfterYear ( int year ) {
        bookService
                .findAllBooksAfterYear ( year )
                .stream ( )
                .map ( Book::getTitle )
                .forEach ( System.out::println );
    }

    private void seedData () throws IOException {
        categoryService.seedCategories ( );
        authorService.seedAuthors ( );
        bookService.seedBooks ( );
    }
}
