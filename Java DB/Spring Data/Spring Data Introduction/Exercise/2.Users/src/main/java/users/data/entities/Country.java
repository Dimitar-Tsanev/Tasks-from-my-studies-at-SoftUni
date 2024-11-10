package users.data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "countries")
public class Country extends BaseEntity{

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "country", targetEntity = Town.class)
    private Set<Town> towns;

    public Country() {
        this.towns = new HashSet<>();
    }

    public Country ( String name ) {
        this();
        this.name = name;

    }

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }
    public Set<Town> getTowns () {
        return Collections.unmodifiableSet(this.towns);
    }
    public void setTowns ( Set<Town> towns ) {
        this.towns = towns;
    }
    public void addTowns ( Town town ) {
        this.towns.add( town );
    }

}
