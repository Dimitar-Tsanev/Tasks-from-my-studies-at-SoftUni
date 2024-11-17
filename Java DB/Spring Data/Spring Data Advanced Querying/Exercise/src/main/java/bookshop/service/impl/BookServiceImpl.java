package bookshop.service.impl;

import bookshop.model.entity.Author;
import bookshop.model.entity.Book;
import bookshop.model.entity.Category;
import bookshop.model.enums.AgeRestriction;
import bookshop.model.enums.EditionType;
import bookshop.repository.BookRepository;
import bookshop.service.AuthorService;
import bookshop.service.BookService;
import bookshop.service.CategoryService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private static final String BOOKS_FILE_PATH = "src/main/resources/files/books.txt";

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedBooks() throws IOException {
        if (bookRepository.count() > 0) {
            return;
        }

        Files
                .readAllLines(Path.of(BOOKS_FILE_PATH))
                .forEach(row -> {
                    String[] bookInfo = row.split("\\s+");

                    Book book = createBookFromInfo(bookInfo);

                    bookRepository.save(book);
                });
    }

    @Override
    public List<Book> findAllBooksAfterYear(int year) {
        return bookRepository
                .findAllByReleaseDateAfter(LocalDate.of(year, 12, 31));
    }

    @Override
    public List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year) {
        return bookRepository
                .findAllByReleaseDateBefore(LocalDate.of(year, 1, 1))
                .stream()
                .map(book -> String.format("%s %s", book.getAuthor().getFirstName(),
                        book.getAuthor().getLastName()))
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName) {
       return bookRepository
                .findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(firstName, lastName)
                .stream()
                .map(book -> String.format("%s %s %d",
                        book.getTitle(),
                        book.getReleaseDate(),
                        book.getCopies()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllBooksByAgeRestriction ( String ageRestriction ) {
        return bookRepository.findAllByAgeRestriction ( AgeRestriction.valueOf ( ageRestriction.toUpperCase (  ) ) )
                .stream( )
                .map ( Book::getTitle  )
                .toList ();
    }

    @Override
    public List<String> findAllBooksByGoldEditionTypeWithLessThan5000Copies () {
        return bookRepository.findAllByEditionTypeAndCopiesLessThan ( EditionType.GOLD, 5000 )
                .stream ()
                .map ( Book::getTitle ).toList ();
    }

    @Override
    public List<String> findBooksWithPriceLessThan5AndHigherThan40 () {
        BigDecimal priceLower = BigDecimal.valueOf ( 5 );
        BigDecimal priceUpper =  BigDecimal.valueOf ( 40 );
        return bookRepository.findAllByPriceLessThanOrPriceGreaterThan ( priceLower,priceUpper )
                .stream ()
                .map (b -> String.format ( "%s - $%.2f",b.getTitle (),b.getPrice () ))
                .toList ();
    }

    @Override
    public List<String> findAllBooksNotReleasedInYear ( int year ) {
        LocalDate dateBefore = LocalDate.of(year, 1,1);
        LocalDate dateAfter = LocalDate.of(year, 12, 31);

        return bookRepository.findByReleaseDateBeforeOrReleaseDateAfter (dateBefore, dateAfter)
                .stream( )
                .map ( Book::getTitle )
                .toList ();
    }

    @Override
    public List<String> findAllBooksReleasedBefore ( String date ) {
        LocalDate formatedDate = LocalDate.parse ( date, DateTimeFormatter.ofPattern ("dd-MM-yyyy") );

        return bookRepository.findAllByReleaseDateBefore ( formatedDate )
                .stream( )
                .map (b -> String.format ( "%s %s %.2f",
                        b.getTitle (),
                        b.getEditionType (),
                        b.getPrice () ) )
                .toList ();
    }

    @Override
    public List<String> findAllBooksTitleContaining ( String bookTitle ) {
        return bookRepository.findAllByTitleContainingIgnoreCase ( bookTitle )
                .stream ()
                .map ( Book::getTitle ).toList ();
    }

    @Override
    public List<String> findAllBooksOfAuthorLastNameEndWith ( String authorLastName ) {
        return bookRepository.findAllByAuthor_LastNameStartingWith ( authorLastName )
                .stream( )
                .map ( b-> String.format("%s (%s %s)",
                        b.getTitle(),b.getAuthor().getFirstName (),
                        b.getAuthor ().getLastName ()) )
                .toList ();
    }

    @Override
    public int findBooksWithTitleSizeLongerThan ( int titleLength ) {
        return bookRepository.countAllByTitleGreaterThan ( titleLength );
    }

    @Override
    public String getBookInfoByTitle (String title) {
        Book book = bookRepository.getBookByTitle ( title );

        return String.format ( "%s %s %s %.2f",
                book.getTitle(),
                book.getEditionType (),
                book.getAgeRestriction (),
                book.getPrice ());
    }

    @Override
    public int increaseBooksCopiesOfBooksReleasedAfter ( String date, int copies ) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        LocalDate formatedDate = LocalDate.parse(date, formatter);

        return copies * bookRepository.updateBooksCopiesWhereReleasedAfterDate ( formatedDate, copies );
    }

    @Override
    public int deleteBooksWithCopiesLessThan ( int copies ) {
        return bookRepository.deleteBooksByCopiesLessThan ( copies );
    }

    private Book createBookFromInfo(String[] bookInfo) {
        EditionType editionType = EditionType.values()[Integer.parseInt(bookInfo[0])];
        LocalDate releaseDate = LocalDate
                .parse(bookInfo[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
        Integer copies = Integer.parseInt(bookInfo[2]);
        BigDecimal price = new BigDecimal(bookInfo[3]);
        AgeRestriction ageRestriction = AgeRestriction
                .values()[Integer.parseInt(bookInfo[4])];
        String title = Arrays.stream(bookInfo)
                .skip(5)
                .collect(Collectors.joining(" "));

        Author author = authorService.getRandomAuthor();
        Set<Category> categories = categoryService
                .getRandomCategories();

        return new Book(editionType, releaseDate, copies, price, ageRestriction, title, author, categories);

    }
}
