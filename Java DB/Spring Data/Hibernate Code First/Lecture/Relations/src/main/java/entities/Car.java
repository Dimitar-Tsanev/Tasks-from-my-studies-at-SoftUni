package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "cars")
public class Car extends Vehicle{

    @Basic
    private Integer seats;

    @OneToOne (targetEntity = PlateNumber.class)
    @PrimaryKeyJoinColumn
    private PlateNumber plateNumber;

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
