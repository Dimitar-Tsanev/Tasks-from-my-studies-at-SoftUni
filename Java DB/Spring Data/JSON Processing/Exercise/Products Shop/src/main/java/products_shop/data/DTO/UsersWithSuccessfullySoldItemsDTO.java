package products_shop.data.DTO;

import com.google.gson.annotations.Expose;

import java.util.Set;

public class UsersWithSuccessfullySoldItemsDTO {
    @Expose
    private String firstName;
    @Expose
    private String lastName;

    @Expose
    private Set<SoledProduct> soledProduct;

    public String getFirstName () {
        return firstName;
    }

    public void setFirstName ( String firstName ) {
        this.firstName = firstName;
    }

    public String getLastName () {
        return lastName;
    }

    public void setLastName ( String lastName ) {
        this.lastName = lastName;
    }

    public Set<SoledProduct> getSoledProduct () {
        return soledProduct;
    }

    public void setSoledProduct ( Set<SoledProduct> soledProduct ) {
        this.soledProduct = soledProduct;
    }
}
