package users.data.entities;

import jakarta.persistence.*;
import users.data.entities.enums.AccessSpecifier;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "albums")
public class Album extends BaseEntity {

    private String name;

    private Color backgroundColor;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    private AccessSpecifier type;

    @ManyToMany
    @JoinTable(name = "albums_pictures",
            joinColumns = @JoinColumn (name = "album_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "picture_id", referencedColumnName = "id")
    )
    private Set<Picture> pictures;

    public Album () {
        this.pictures = new HashSet<> ();
    }

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public Color getBackgroundColor () {
        return backgroundColor;
    }

    public void setBackgroundColor ( Color backgroundColor ) {
        this.backgroundColor = backgroundColor;
    }

    public User getUser () {
        return user;
    }

    public void setUser ( User user ) {
        this.user = user;
    }

    public AccessSpecifier getType () {
        return type;
    }

    public void setType ( AccessSpecifier type ) {
        this.type = type;
    }

    public Set<Picture> getPictures () {
        return pictures;
    }

    public void setPictures ( Set<Picture> pictures ) {
        this.pictures = pictures;
    }
}
