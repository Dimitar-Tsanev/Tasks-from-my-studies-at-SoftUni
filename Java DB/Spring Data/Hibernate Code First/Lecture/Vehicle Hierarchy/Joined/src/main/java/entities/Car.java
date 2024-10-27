package entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "cars")
public class Car extends Vehicle{

    @Basic
    private Integer seats;

    public Car(){
        super();
    }

    public int getSeats () {
        return seats;
    }

    public void setSeats ( int seats ) {
        this.seats = seats;
    }
}
