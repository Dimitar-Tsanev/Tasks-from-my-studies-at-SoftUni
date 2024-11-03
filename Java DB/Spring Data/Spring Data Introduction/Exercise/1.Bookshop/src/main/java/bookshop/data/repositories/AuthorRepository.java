package bookshop.data.repositories;

import bookshop.data.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    List<Author> findAllByBooksReleaseDateBefore( LocalDate localDate);
    List<Author> findALLByOrderByBooksDesc();
}
