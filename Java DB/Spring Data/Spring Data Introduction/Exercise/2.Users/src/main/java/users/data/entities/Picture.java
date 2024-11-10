package users.data.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pictures")
public class Picture extends BaseEntity {

    @Basic
    private String title;

    private String caption;

    @Basic(optional = false)
    private String path;

    @ManyToMany(mappedBy = "pictures", targetEntity = Album.class)
    private Set<Album> albums;

    public Picture () {
        this.albums = new HashSet<> ();
    }

    public String getTitle () {
        return title;
    }

    public void setTitle ( String title ) {
        this.title = title;
    }

    public String getCaption () {
        return caption;
    }

    public void setCaption ( String caption ) {
        this.caption = caption;
    }

    public String getPath () {
        return path;
    }

    public void setPath ( String path ) {
        this.path = path;
    }

    public Set<Album> getAlbums () {
        return albums;
    }

    public void addAlbums ( Set<Album> albums ) {
        this.albums = albums;
    }
}
