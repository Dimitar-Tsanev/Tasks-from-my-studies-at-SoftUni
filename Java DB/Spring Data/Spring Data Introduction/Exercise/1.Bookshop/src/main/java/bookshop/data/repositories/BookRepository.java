package bookshop.data.repositories;

import bookshop.data.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByReleaseDateAfter ( LocalDate releaseDate );
    List<Book> findByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc ( String firstName, String lastName );
}