package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "bike")
public class Bike extends Vehicle{

    public Bike(){
        super();
    }
}
