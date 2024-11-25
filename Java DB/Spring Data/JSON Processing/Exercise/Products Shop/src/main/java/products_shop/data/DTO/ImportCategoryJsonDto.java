package products_shop.data.DTO;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class ImportCategoryJsonDto implements Serializable {
    @Expose
    private String name;

    public ImportCategoryJsonDto () {
    }

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }
}
