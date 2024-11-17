package bookshop.repository;

import bookshop.model.entity.Book;
import bookshop.model.enums.AgeRestriction;
import bookshop.model.enums.EditionType;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByReleaseDateAfter(LocalDate releaseDateAfter);

    List<Book> findAllByReleaseDateBefore(LocalDate releaseDateBefore);

    List<Book> findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(String author_firstName, String author_lastName);

    List<Book> findAllByAgeRestriction( AgeRestriction ageRestriction);

    List<Book> findAllByEditionTypeAndCopiesLessThan( EditionType editionType, Integer copies);

    List<Book> findAllByPriceLessThanOrPriceGreaterThan( BigDecimal lower, BigDecimal upper);

    List<Book> findByReleaseDateBeforeOrReleaseDateAfter ( LocalDate releaseDateBefore, LocalDate releaseDateAfter);

    List<Book> findAllByTitleContainingIgnoreCase( String title);

    List<Book> findAllByAuthor_LastNameStartingWith( String lastName);

    @Query(value = "SELECT count(b) FROM Book b WHERE length(b.title) > :length")
    int countAllByTitleGreaterThan(int length);

    Book getBookByTitle(String title);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Book b SET b.copies = b.copies + :copies WHERE b.releaseDate > :releaseDate")
    int updateBooksCopiesWhereReleasedAfterDate( @Param("releaseDate") LocalDate releaseDate, @Param("copies") Integer copies);

    @Transactional
    int deleteBooksByCopiesLessThan(Integer copies);
}
