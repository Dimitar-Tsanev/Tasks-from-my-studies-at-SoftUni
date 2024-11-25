package products_shop.data.DTO;

import com.google.gson.annotations.Expose;
import products_shop.data.entity.User;

import java.io.Serializable;
import java.math.BigDecimal;

public class ImportProductJsonDto implements Serializable {

    @Expose
    private String name;

    @Expose
    private BigDecimal price;

    public ImportProductJsonDto () {
    }

    public String getName () {
        return name;
    }

    public void setProductName ( String productName ) {
        this.name = productName;
    }

    public BigDecimal getPrice () {
        return price;
    }

    public void setPrice ( BigDecimal price ) {
        this.price = price;
    }
}
