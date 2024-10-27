package entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@DiscriminatorValue ( value = "bike")
public class Bike extends Vehicle{

    public Bike(){
        super();
    }
}
