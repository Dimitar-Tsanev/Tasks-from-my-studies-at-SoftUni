package entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    @Basic
    private String type;

    @Basic
    private String model;

    @Basic
    private BigDecimal price;

    @Basic
    private  String fuelType;

    protected Vehicle(){}

    public long getId () {
        return id;
    }

    public void setId ( long id ) {
        this.id = id;
    }

    public String getType () {
        return type;
    }

    public void setType ( String type ) {
        this.type = type;
    }

    public String getModel () {
        return model;
    }

    public void setModel ( String model ) {
        this.model = model;
    }

    public BigDecimal getPrice () {
        return price;
    }

    public void setPrice ( BigDecimal price ) {
        this.price = price;
    }

    public String getFuelType () {
        return fuelType;
    }

    public void setFuelType ( String fuelType ) {
        this.fuelType = fuelType;
    }
}
