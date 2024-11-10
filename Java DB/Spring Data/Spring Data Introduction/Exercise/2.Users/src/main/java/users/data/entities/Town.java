package users.data.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "towns")
public class Town extends BaseEntity{

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id", nullable = false)
    private Country country;

    public Town () {
    }

    public Town ( String name ) {
        this.name = name;
    }

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public Country getCountry () {
        return country;
    }

    public void setCountry ( Country country ) {
        this.country = country;
    }
}
