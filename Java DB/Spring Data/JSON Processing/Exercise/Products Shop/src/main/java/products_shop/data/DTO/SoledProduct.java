package products_shop.data.DTO;

import com.google.gson.annotations.Expose;

public class SoledProduct {
    @Expose
    private String name;
    @Expose
    private double price;
    @Expose
    private String buyerFirstName;
    @Expose
    private String buyerLastName;

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public double getPrice () {
        return price;
    }

    public void setPrice ( double price ) {
        this.price = price;
    }

    public String getBuyerFirstName () {
        return buyerFirstName;
    }

    public void setBuyerFirstName ( String buyerFirstName ) {
        this.buyerFirstName = buyerFirstName;
    }

    public String getBuyerLastName () {
        return buyerLastName;
    }

    public void setBuyerLastName ( String buyerLastName ) {
        this.buyerLastName = buyerLastName;
    }
}
