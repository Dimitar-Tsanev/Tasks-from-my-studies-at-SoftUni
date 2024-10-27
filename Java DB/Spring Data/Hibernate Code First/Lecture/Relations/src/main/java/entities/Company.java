package entities;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.Set;

@Entity
@Table (name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String name;

    @OneToMany (mappedBy = "company", targetEntity = Plane.class)
    private Set<Plane> planes;

    public Company () {
    }

    public long getId () {
        return id;
    }

    public void setId ( long id ) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public Set<Plane> getPlanes () {
        return planes;
    }

    public void setPlanes ( Set<Plane> planes ) {
        this.planes = planes;
    }
}
