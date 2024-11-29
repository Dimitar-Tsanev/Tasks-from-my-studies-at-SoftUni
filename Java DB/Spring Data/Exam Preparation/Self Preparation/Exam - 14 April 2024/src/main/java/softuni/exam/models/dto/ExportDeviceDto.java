package softuni.exam.models.dto;


public class ExportDeviceDto {
    private static final String DEVICE_TEMPLATE ="Device brand: %s%n   *Model: %s%n   **Storage: %d%n   ***Price: %.2f";

    private String brand;

    private String model;

    private Double price;

    private Integer storage;

    public ExportDeviceDto () {
    }

    public String getBrand () {
        return brand;
    }

    public void setBrand ( String brand ) {
        this.brand = brand;
    }

    public String getModel () {
        return model;
    }

    public void setModel ( String model ) {
        this.model = model;
    }

    public Double getPrice () {
        return price;
    }

    public void setPrice ( Double price ) {
        this.price = price;
    }

    public Integer getStorage () {
        return storage;
    }

    public void setStorage ( Integer storage ) {
        this.storage = storage;
    }

    @Override
    public String toString () {
        return String.format(DEVICE_TEMPLATE, brand, model, storage, price);
    }
}
