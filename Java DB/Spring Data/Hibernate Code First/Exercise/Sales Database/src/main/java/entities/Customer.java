package entities;

import jakarta.persistence.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(name = "credit_card_number")
    private String creditCardNumber;

    @OneToMany(mappedBy = "customer", targetEntity = Sale.class)
    private Set<Sale> sales;

    public Customer () {
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

    public String getEmail () {
        return email;
    }

    public void setEmail ( String email ) {
        this.email = email;
    }

    public String getCreditCardNumber () {
        return creditCardNumber;
    }

    public void setCreditCardNumber ( String creditCardNumber ) {
        this.creditCardNumber = creditCardNumber;
    }

    public Set<Sale> getSales () {
        return Collections.unmodifiableSet ( sales);
    }

    public void addSales ( Sale sale ) {
        this.sales.add ( sale );
    }
}
