package entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "plane")
public class Plane extends Vehicle{

    @Basic
    private Integer passengerCapacity;

    @Basic
    private String airline;

    public Plane(){
        super();
    }

    public Integer getPassengerCapacity () {
        return passengerCapacity;
    }

    public void setPassengerCapacity ( Integer passengerCapacity ) {
        this.passengerCapacity = passengerCapacity;
    }

    public String getAirline () {
        return airline;
    }

    public void setAirline ( String airline ) {
        this.airline = airline;
    }
}

