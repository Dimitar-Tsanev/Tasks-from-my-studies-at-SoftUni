package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "planes")
public class Plane extends Vehicle{

    @Column (name = "passenger_capacity")
    private Integer passengerCapacity;

    @Column(name = "air_line")
    private String airline;

    @ManyToOne(optional = false)
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;

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

