package entities;

import jakarta.persistence.Basic;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@DiscriminatorValue( value = "truck")
public class Truck extends Vehicle{

    @Basic
    double loadCapacity;

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
