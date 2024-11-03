package bookshop.service;

import bookshop.data.entities.Author;
import bookshop.data.repositories.AuthorRepository;
import bookshop.service.interfaces.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@Service
public class AuthorServiceImpl implements AuthorService {
    private static final Path RESOURCE_PATH = Path.of (  "src/main/resources/files/authors.txt").toAbsolutePath ();

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void seed () throws IOException {
        if (authorRepository.count() != 0) {
            return;
        }

        Files.readAllLines ( RESOURCE_PATH ).forEach ( l -> {
            String[] authorData = l.split ( "\\s+" );
            Author author = new Author(authorData[0], authorData[1]);
            authorRepository.save(author);
        } );
    }

    @Override
    public Author getRandomAuthor () {
        Random random = new Random ( );

        long randomId = random.nextLong (authorRepository.count () + 1);

        if(randomId >= authorRepository.count() ){
            randomId -= authorRepository.count();
        }

        if ( randomId == 0L ){
            randomId = 1L;
        }

        return authorRepository.getReferenceById (randomId );
    }

    @Override
    public List<Author> getAuthorsWithBooksBefore1990 () {
        return authorRepository.findAllByBooksReleaseDateBefore ( LocalDate.of(1990, 1, 1));
    }

    @Override
    public List<Author> getAllAuthorOrderedByBooksCount () {
        return authorRepository.findALLByOrderByBooksDesc ();
    }
}
