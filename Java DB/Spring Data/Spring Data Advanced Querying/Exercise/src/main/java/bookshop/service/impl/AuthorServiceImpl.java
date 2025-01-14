package bookshop.service.impl;

import bookshop.model.entity.Author;
import bookshop.repository.AuthorRepository;
import bookshop.service.AuthorService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    private static final String AUTHORS_FILE_PATH = "src/main/resources/files/authors.txt";

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void seedAuthors() throws IOException {
        if (authorRepository.count() > 0) {
            return;
        }

        Files
                .readAllLines(Path.of(AUTHORS_FILE_PATH))
                .forEach(row -> {
                    String[] fullName = row.split("\\s+");
                    Author author = new Author(fullName[0], fullName[1]);

                    authorRepository.save(author);
                });
    }

    @Override
    public Author getRandomAuthor() {
        long randomId = ThreadLocalRandom
                .current().nextLong(1,
                        authorRepository.count() + 1);

        return authorRepository
                .findById(randomId)
                .orElse(null);
    }

    @Override
    public List<String> getAllAuthorsOrderByCountOfTheirBooks() {
        return authorRepository
                .findAllByBooksSizeDESC()
                .stream()
                .map(author -> String.format("%s %s %d",
                        author.getFirstName(),
                        author.getLastName(),
                        author.getBooks().size()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAuthorsFirstNameEndWith ( String firstNameEnd ) {
        return authorRepository.findAllByFirstNameEndsWith ( firstNameEnd )
                .stream ()
                .map ( a -> a.getFirstName () + " " + a.getLastName()  )
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getAuthorsTotalBooksCopies () {
        return  authorRepository.findAllByBookCopiesCount ();

    }

    @Transactional
    @Override
    public int getAuthorBooksCount ( String authorName ) {
        String firstName = authorName.split ( "\\s+" )[0];
        String lastName = authorName.split ( "\\s+" )[1];

        return authorRepository.findAuthorAllBooksCount ( firstName, lastName );
    }
}
