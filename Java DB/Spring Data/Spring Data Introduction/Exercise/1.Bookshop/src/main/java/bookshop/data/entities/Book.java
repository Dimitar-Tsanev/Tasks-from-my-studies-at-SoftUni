package bookshop.data.entities;

import bookshop.data.entities.enums.AgeRestriction;
import bookshop.data.entities.enums.EditionType;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table (name = "books")
public class Book extends BaseEntity {

    @Column(name = "age_restriction", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private AgeRestriction ageRestriction;

    @Basic(optional = false)
    private int copies;

    @Basic
    private String description;

    @Column(name = "edition_type", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private EditionType editionType;

    @Basic(optional = false)
    private BigDecimal price;

    @Column(name = "release_date")
    LocalDate releaseDate;

    @Column(nullable = false, length = 50)
    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id",nullable = false)
    private Author author;

    @ManyToMany
    @JoinTable(name = "books_categories",
        joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id",nullable = false),
        inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    )
    private Set<Category> categories;

    public Book () {
    }

    public Book ( String title, EditionType editionType, BigDecimal price,
                  LocalDate releaseDate, AgeRestriction ageRestriction,
                  Author author, Set<Category> categories, int copies ) {

        this.title = title;
        this.editionType = editionType;
        this.price = price;
        this.releaseDate = releaseDate;
        this.ageRestriction = ageRestriction;
        this.author = author;
        this.categories = categories;
        this.copies = copies;
    }

    public AgeRestriction getAgeRestriction () {
        return ageRestriction;
    }

    public void setAgeRestriction ( AgeRestriction ageRestriction ) {
        this.ageRestriction = ageRestriction;
    }

    public int getCopies () {
        return copies;
    }

    public void setCopies ( int copies ) {
        this.copies = copies;
    }

    public String getDescription () {
        return description;
    }

    public void setDescription ( String description ) {
        this.description = description;
    }

    public EditionType getEditionType () {
        return editionType;
    }

    public void setEditionType ( EditionType editionType ) {
        this.editionType = editionType;
    }

    public BigDecimal getPrice () {
        return price;
    }

    public void setPrice ( BigDecimal price ) {
        this.price = price;
    }

    public LocalDate getReleaseDate () {
        return releaseDate;
    }

    public void setReleaseDate ( LocalDate releaseDate ) {
        this.releaseDate = releaseDate;
    }

    public String getTitle () {
        return title;
    }

    public void setTitle ( String title ) {
        this.title = title;
    }

    public Author getAuthor () {
        return author;
    }

    public void setAuthor ( Author author ) {
        this.author = author;
    }

    public Set<Category> getCategories () {
        return categories;
    }

    public void setCategories ( Set<Category> categories ) {
        this.categories = categories;
    }

    @Override
    public String toString () {
        return String.format (  "%s written by %s %s from %s %.2f",
                title, author.getFirstName (), author.getLastName (), releaseDate.toString (), price );

    }
}
