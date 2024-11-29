package softuni.exam.models.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "constellations")
public class Constellation extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @Basic(optional = false)
    private String description;

    @OneToMany(mappedBy = "constellation",targetEntity = Star.class)
    private Set<Star> stars;

    public Constellation() {
        stars = new HashSet<> ();
    }

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public String getDescription () {
        return description;
    }

    public void setDescription ( String description ) {
        this.description = description;
    }

    public Set<Star> getStars () {
        return stars;
    }

    public void setStars ( Set<Star> stars ) {
        this.stars = stars;
    }
}
