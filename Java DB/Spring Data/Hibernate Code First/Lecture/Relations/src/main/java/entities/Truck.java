package entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "trucks")
public class Truck extends Vehicle{

    @Column(name = "load_capacity")
    double loadCapacity;

    @ManyToMany
    @JoinTable(name = "trucks_drivers",
            joinColumns = @JoinColumn(name = "truck_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "driver_id", referencedColumnName = "id"))
    private Set<Driver> drivers;

    public Truck(){
        super();
    }

    public double getLoadCapacity () {
        return loadCapacity;
    }

    public void setLoadCapacity ( double loadCapacity ) {
        this.loadCapacity = loadCapacity;
    }
}
