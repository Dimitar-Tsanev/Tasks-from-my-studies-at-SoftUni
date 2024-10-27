package entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Basic
    private Double quantity;

    @Column(nullable = false)
    private BigDecimal price;

    @OneToMany(mappedBy = "product", targetEntity = Sale.class)
    private final Set<Sale> sales;

    public Product () {
        this.sales = new HashSet<> ( );
    }

    public int getId () {
        return id;
    }


    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public Double getQuantity () {
        return quantity;
    }

    public void setQuantity ( Double quantity ) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice () {
        return price;
    }

    public void setPrice ( BigDecimal price ) {
        this.price = price;
    }

    public Set<Sale> getSales () {
        return Collections.unmodifiableSet ( this.sales );
    }

    public void addSale(Sale sale){
        this.sales.add ( sale );
    }
}
