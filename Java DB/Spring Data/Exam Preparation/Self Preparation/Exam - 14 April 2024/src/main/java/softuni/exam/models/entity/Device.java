package softuni.exam.models.entity;

import softuni.exam.models.entity.enums.DeviceType;

import javax.persistence.*;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "devices")
public class Device extends BaseEntity {

    @Basic(optional = false)
    private String brand;

    @Enumerated(EnumType.STRING)
    @Column(name = "device_type ")
    private DeviceType deviceType;

    @Column(nullable = false, unique = true)
    private String model;

    @Positive
    private Double price;

    @Positive
    private Integer storage;

    @ManyToOne
    @JoinColumn(name = "sale_id", referencedColumnName = "id")
    private Sale sale;

    public Device () {
    }

    public String getBrand () {
        return brand;
    }

    public void setBrand ( String brand ) {
        this.brand = brand;
    }

    public DeviceType getDeviceType () {
        return deviceType;
    }

    public void setDeviceType ( DeviceType deviceType ) {
        this.deviceType = deviceType;
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

    public Sale getSale () {
        return sale;
    }

    public void setSale ( Sale sale ) {
        this.sale = sale;
    }
}
