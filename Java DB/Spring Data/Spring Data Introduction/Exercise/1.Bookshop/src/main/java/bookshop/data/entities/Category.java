package bookshop.data.entities;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String name;

    @ManyToMany(mappedBy = "categories", targetEntity = Book.class, fetch = FetchType.EAGER)
    private Set<Book> books;

    public Category () {
        this.books = new HashSet<> ();
    }

    public Category ( String name ) {
        this.name = name;
        this.books = new HashSet<> ();
    }

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public Set<Book> getBooks () {
        return books;
    }

    public void setBooks ( Set<Book> books ) {
        this.books = books;
    }

    @Override
    public boolean equals ( Object o ) {
        if ( this == o ) return true;
        if ( o == null || getClass ( ) != o.getClass ( ) ) return false;

        Category category = (Category) o;
        return name.equals ( category.name ) && books.equals ( category.books );
    }

    @Override
    public int hashCode () {
        int result = name.hashCode ( );
        result = 31 * result + books.hashCode ( );
        return result;
    }

}
