package bookshop.service;

import bookshop.data.entities.Author;
import bookshop.data.entities.Book;
import bookshop.data.entities.Category;
import bookshop.data.entities.enums.AgeRestriction;
import bookshop.data.entities.enums.EditionType;
import bookshop.data.repositories.BookRepository;
import bookshop.service.interfaces.AuthorService;
import bookshop.service.interfaces.BookService;
import bookshop.service.interfaces.CategoryService;
import bookshop.service.interfaces.DatabaseSeed;
import org.springframework.beans.factory.annotation.Autowired;
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
public class BookServiceImpl implements BookService, DatabaseSeed {
    private static final Path RESOURCE_PATH = Path.of (  "src/main/resources/files/books.txt").toAbsolutePath ();

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    @Override
    public void seed () throws IOException {
        if (bookRepository.count() != 0) {
            return;
        }

        Files.readAllLines ( RESOURCE_PATH ).forEach ( l -> {
            String[] authorData = l.split ( "\\s+" );
            Author author = authorService.getRandomAuthor();

            EditionType editionType = EditionType.values()[Integer.parseInt(authorData[0])];

            LocalDate releaseDate = LocalDate.parse(authorData[1], DateTimeFormatter.ofPattern("d/M/yyyy"));

            int copies = Integer.parseInt(authorData[2]);

            BigDecimal price = new BigDecimal(authorData[3]);

            AgeRestriction ageRestriction = AgeRestriction
                    .values()[Integer.parseInt(authorData[4])];

            String title = Arrays.stream(authorData)
                    .skip(5)
                    .collect( Collectors.joining(" "));

            Set<Category> categories = categoryService.getRandomCategories ();

            Book book = new Book(title, editionType, price, releaseDate,
                    ageRestriction, author, categories, copies);

            bookRepository.save(book);
        } );
    }

    @Override
    public List<Book> findBooksReleasedAfter2000 () {
        LocalDate year2000 = LocalDate.of(2000, 12, 31);

        return bookRepository.findByReleaseDateAfter ( year2000 );
    }

    @Override
    public List<Book> findBooksByAuthorFullName ( String authorFullName ) {
        String[] authorData = authorFullName.split ( "\\s+" );

        return bookRepository.findByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc ( authorData[0], authorData[1] );
    }
}
