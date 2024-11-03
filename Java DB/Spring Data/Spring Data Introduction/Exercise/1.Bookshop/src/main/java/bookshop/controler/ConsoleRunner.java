package bookshop.controler;

import bookshop.data.entities.Author;
import bookshop.data.entities.Book;
import bookshop.service.interfaces.AuthorService;
import bookshop.service.interfaces.BookService;
import bookshop.service.interfaces.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private final AuthorService authorService;
    private final BookService bookService;
    private final CategoryService categoryService;

    public ConsoleRunner(AuthorService authorService, BookService bookService, CategoryService categoryService) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.categoryService = categoryService;
    }

    @Override
    public void run ( String... args ) throws Exception {
        authorService.seed ();
        categoryService.seed ();
        bookService.seed ();

        printBooks ( bookService.findBooksReleasedAfter2000());
        printAuthors (  authorService.getAuthorsWithBooksBefore1990 ());
        printAuthorsWithBookCount ( authorService.getAllAuthorOrderedByBooksCount () );
        printBooksTitleReleaseDateAndCopies (bookService.findBooksByAuthorFullName ( "George Powell" )  );
    }

    private void printBooksTitleReleaseDateAndCopies ( List<Book> books ) {
        books.forEach ( b -> System.out.printf ( "%s %s %d%n", b.getTitle (), b.getReleaseDate (), b.getCopies () ) );
    }

    private void printAuthorsWithBookCount ( List<Author> authors ) {
        authors.forEach (a -> System.out.println (a + " books: " +a.getBooks().size() ));
    }

    private void printBooks( List<Book> books ){
        books.forEach ( System.out::println );
    }

    private void printAuthors ( List<Author> authors ){
        authors.forEach ( System.out::println );
    }
}
