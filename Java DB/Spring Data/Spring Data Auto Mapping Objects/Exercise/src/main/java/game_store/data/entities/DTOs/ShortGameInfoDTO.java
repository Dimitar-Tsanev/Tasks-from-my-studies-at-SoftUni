package game_store.data.entities.DTOs;

import java.math.BigDecimal;

public class ShortGameInfoDTO {

    private String title;
    private BigDecimal price;

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

    @Override
    public String toString () {
        return title + " " + price;
    }
}
