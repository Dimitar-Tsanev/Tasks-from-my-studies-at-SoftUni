package entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @ManyToOne(optional = false)
    @JoinColumn(name = "store_location_id", referencedColumnName = "id")
    private StoreLocation storeLocation;

    @Basic
    private Date date;

    public Sale () {
    }

    public int getId () {
        return id;
    }

    public Product getProduct () {
        return product;
    }

    public void setProduct ( Product product ) {
        this.product = product;
    }

    public Customer getCustomer () {
        return customer;
    }

    public void setCustomer ( Customer customer ) {
        this.customer = customer;
    }

    public StoreLocation getStoreLocation () {
        return storeLocation;
    }

    public void setStoreLocation ( StoreLocation storeLocation ) {
        this.storeLocation = storeLocation;
    }

    public Date getDate () {
        return date;
    }

    public void setDate ( Date date ) {
        this.date = date;
    }
}
