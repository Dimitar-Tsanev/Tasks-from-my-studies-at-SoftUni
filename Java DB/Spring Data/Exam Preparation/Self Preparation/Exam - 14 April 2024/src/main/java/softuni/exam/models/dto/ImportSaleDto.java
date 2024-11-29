package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.Size;

public class ImportSaleDto {

    @Expose
    private Boolean discounted;

    @Expose
    @Size(min = 7, max = 7)
    private String number;

    @Expose
    private String saleDate;

    @Expose
    private Long seller;

    public ImportSaleDto () {
    }

    public Boolean getDiscounted () {
        return discounted;
    }

    public void setDiscounted ( Boolean discounted ) {
        this.discounted = discounted;
    }

    public String getNumber () {
        return number;
    }

    public void setNumber ( String number ) {
        this.number = number;
    }

    public String getSaleDate () {
        return saleDate;
    }

    public void setSaleDate ( String saleDate ) {
        this.saleDate = saleDate;
    }

    public Long getSeller () {
        return seller;
    }

    public void setSeller ( Long seller ) {
        this.seller = seller;
    }
}
