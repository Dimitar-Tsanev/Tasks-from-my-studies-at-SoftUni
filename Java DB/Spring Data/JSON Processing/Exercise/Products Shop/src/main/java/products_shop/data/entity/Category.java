package products_shop.data.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import org.hibernate.validator.constraints.Length;

import java.util.Set;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

    @Basic
    @Length(min = 3, max = 15)
    private String name;

    @ManyToMany(mappedBy = "categories", targetEntity = Product.class)
    private Set<Product> products;

    public Category () {
    }

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public Set<Product> getProducts () {
        return products;
    }

    public void setProducts ( Set<Product> products ) {
        this.products = products;
    }

    @Override
    public boolean equals ( Object o ) {
        if ( o == null || getClass ( ) != o.getClass ( ) ) return false;

        Category category = (Category) o;
        return name.equals ( category.name );
    }

    @Override
    public int hashCode () {
        return name.hashCode ( );
    }
}
