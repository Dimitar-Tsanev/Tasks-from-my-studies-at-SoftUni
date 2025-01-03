package game_store.data.entities.DTOs;

import java.math.BigDecimal;
import java.time.LocalDate;

public class GameFullInfo {
    private String title;
    private BigDecimal price;
    private String description;
    private LocalDate releaseDate;

    public String getTitle () {
        return title;
    }

    public void setTitle ( String title ) {
        this.title = title;
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
    public String toString () {
        return String.format ( "Title: %s%n" +
        "Price: %.2f%n" +
        "Description: %s%n"+
        "Release date: %s%n",
                title, price, description, releaseDate.toString () );
    }
}
