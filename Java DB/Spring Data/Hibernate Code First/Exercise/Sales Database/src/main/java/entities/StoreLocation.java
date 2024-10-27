package entities;


import jakarta.persistence.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "store_locations")
public class StoreLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "location_name", nullable = false)
    private String locationName;

    @OneToMany(mappedBy = "storeLocation", targetEntity = Sale.class)
    private final Set<Sale> sales;

    public StoreLocation () {
        this.sales = new HashSet<> ( );
    }

    public int getId () {
        return id;
    }

    public String getLocationName () {
        return locationName;
    }

    public void setLocationName ( String locationName ) {
        this.locationName = locationName;
    }

    public Set<Sale> getSales () {
        return Collections.unmodifiableSet ( this.sales );
    }

    public void addSale(Sale sale){
        this.sales.add ( sale );
    }
}
