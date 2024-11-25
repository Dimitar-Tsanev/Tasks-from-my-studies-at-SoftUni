package products_shop.data.entity;

import jakarta.persistence.*;

import org.hibernate.validator.constraints.Length;

import java.util.Set;

@Entity
@Table(name ="products")
public class Product extends BaseEntity {

    @Length(min = 3)
    @Basic(optional = false)
    private String name;

    @Basic
    private Double price;

    @ManyToOne
    @JoinColumn(name = "seller_id", referencedColumnName = "id")
    private User seller;

    @JoinColumn(name = "buyer_id", referencedColumnName = "id", nullable = true)
    @ManyToOne
    private User buyer;

    @ManyToMany
    @JoinTable(
            name = "products_categories",
            joinColumns = @JoinColumn(name = "products_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "categories_id", referencedColumnName = "id")
    )
    private Set<Category> categories;

    public Product () {

    }

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public Double getPrice () {
        return price;
    }

    public void setPrice ( Double price ) {
        this.price = price;
    }

    public User getSeller () {
        return seller;
    }

    public void setSeller ( User seller ) {
        this.seller = seller;
    }

    public User getBuyer () {
        return buyer;
    }

    public void setBuyer ( User buyer ) {
        this.buyer = buyer;
    }

    public Set<Category> getCategories () {
        return categories;
    }

    public void setCategories ( Set<Category> categories ) {
        this.categories = categories;
    }

    @Override
    public boolean equals ( Object o ) {
        if ( o == null || getClass ( ) != o.getClass ( ) ) return false;

        Product product = (Product) o;
        return name.equals ( product.name ) && price.equals ( product.price ) && seller.equals ( product.seller );
    }

    @Override
    public int hashCode () {
        int result = name.hashCode ( );
        result = 31 * result + price.hashCode ( );
        result = 31 * result + seller.hashCode ( );
        return result;
    }
}
