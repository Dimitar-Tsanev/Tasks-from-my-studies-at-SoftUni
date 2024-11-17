package bookshop.repository;

import bookshop.model.entity.Author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM Author a ORDER BY size(a.books) DESC")
    List<Author> findAllByBooksSizeDESC();

    List<Author> findAllByFirstNameEndsWith(String firstNameEnds);

    @Query(value = "select concat(b.author.firstName,' ' ,b.author.lastName,' - ', sum(b.copies) ) FROM Book b GROUP BY b.author order by sum(b.copies) DESC" )
    List<String> findAllByBookCopiesCount();

    @Procedure(procedureName = "usp_find_authors_all_books", outputParameterName = "count")
    int findAuthorAllBooksCount(String firstName, String lastName);
}
