package softuni.exam.models.entity;

import softuni.exam.models.entity.enums.StarType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "stars")
public class Star extends BaseEntity{

    @Column(nullable = false, unique = true)
    private String name;

    @Column(name = "light_years", nullable = false)
    private Double lightYears;

    @Column(nullable = false,columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "star_type")
    private StarType starType;

    @ManyToOne
    @JoinColumn(name = "constellation_id", referencedColumnName = "id")
    private Constellation constellation;

    @OneToMany(mappedBy = "observingStar", targetEntity = Astronomer.class)
    private Set<Astronomer> observers;

    public Star() {
        observers = new HashSet<> ();
    }

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public Double getLightYears () {
        return lightYears;
    }

    public void setLightYears ( Double lightYears ) {
        this.lightYears = lightYears;
    }

    public String getDescription () {
        return description;
    }

    public void setDescription ( String description ) {
        this.description = description;
    }

    public StarType getStarType () {
        return starType;
    }

    public void setStarType ( StarType starType ) {
        this.starType = starType;
    }

    public Constellation getConstellation () {
        return constellation;
    }

    public void setConstellation ( Constellation constellation ) {
        this.constellation = constellation;
    }

    public Set<Astronomer> getObservers () {
        return observers;
    }

    public void setObservers ( Set<Astronomer> observers ) {
        this.observers = observers;
    }

    @Override
    public String toString () {
        String lightYearWithDot = String.format("%.2f", lightYears).replace ( ",","." );
        return String.format ( "Star: %s%n" +
                "   *Distance: %s light years%n"+
                "   **Description: %s%n"+
                "   ***Constellation: %s", name, lightYearWithDot, description, constellation.getName ()
        );
    }
}
