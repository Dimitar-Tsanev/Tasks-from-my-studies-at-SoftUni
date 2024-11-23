package game_store.data.entities.DTOs;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CreateGameDTO {
    @Length(min = 3, max = 100)
    private String title;

    @Length(min = 11, max = 11)
    private String youTubeID;

    @Pattern(regexp = "^(http://)|(https://)[\\w\\W]*")
    private String ThumbnailUrl;

    @Positive
    private double size;

    @Positive
    private BigDecimal price;

    @Length(min = 20)
    private String description;

    private LocalDate releaseDate;

    public CreateGameDTO() {

    }

    public CreateGameDTO ( String title, BigDecimal price, double size, String youTubeID, String thumbnailUrl,  String description, LocalDate releaseDate ) {
        this.title = title;
        this.youTubeID = youTubeID;
        ThumbnailUrl = thumbnailUrl;
        this.size = size;
        this.price = price;
        this.description = description;
        this.releaseDate = releaseDate;
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


    public void setYouTubeID ( String youTubeVideoURL ) {
        this.youTubeID = youTubeID;
    }

    public String getThumbnailUrl () {
        return ThumbnailUrl;
    }


    public void setThumbnailUrl ( String thumbnailUrl ) {
        if ( thumbnailUrl.startsWith ( "http://" ) || thumbnailUrl.startsWith ( "https://" ) ) {
            this.ThumbnailUrl = thumbnailUrl;
        }

        throw new IllegalArgumentException ( "URL must start with 'http://' or 'https://'" );
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
}
