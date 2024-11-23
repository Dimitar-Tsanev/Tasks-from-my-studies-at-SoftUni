package game_store.data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "games")
public class Game extends BaseEntity{

    @Column(unique = true, nullable = false)
    private String title;

    @Column(name = "youtube_id")
    private String youTubeID;

    @Column(name = "thumbnail_url")
    private String ThumbnailUrl;

    private double size;

    private BigDecimal price;

    private String description;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    public Game () {
    }

    public String getTitle () {
        return title;
    }

    public void setTitle ( String title ) {
        this.title = title;
    }

    public String getYouTubeID () {
        return youTubeID;
    }

    public void setYouTubeID ( String youTubeID ) {
        this.youTubeID = youTubeID;
    }

    public String getThumbnailUrl () {
        return ThumbnailUrl;
    }

    public void setThumbnailUrl ( String thumbnailUrl ) {
        ThumbnailUrl = thumbnailUrl;
    }

    public double getSize () {
        return size;
    }

    public void setSize ( double size ) {
        this.size = size;
    }

    public BigDecimal getPrice () {
        return price;
    }

    public void setPrice ( BigDecimal price ) {
        this.price = price;
    }

    public String getDescription () {
        return description;
    }

    public void setDescription ( String description ) {
        this.description = description;
    }

    public LocalDate getReleaseDate () {
        return releaseDate;
    }

    public void setReleaseDate ( LocalDate releaseDate ) {
        this.releaseDate = releaseDate;
    }

    @Override
    public boolean equals ( Object o ) {
        if ( o == null || getClass ( ) != o.getClass ( ) ) return false;

        Game game = (Game) o;
        return title.equals ( game.title );
    }

    @Override
    public int hashCode () {
        return title.hashCode ( );
    }
}
