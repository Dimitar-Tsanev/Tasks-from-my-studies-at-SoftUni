package softuni.exam.models.dto;

import softuni.exam.models.entity.enums.DeviceType;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "device")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportDeviceDto {

    @Size(min = 2, max = 20)
    @XmlElement(required = true)
    private String brand;

    @XmlElement(name = "device_type", type = DeviceType.class)
    private DeviceType deviceType;

    @Size(min = 1, max = 20)
    @XmlElement(required = true)
    private String model;

    @Positive
    @XmlElement
    private Double price;

    @Positive
    @XmlElement
    private Integer storage;

    @XmlElement
    private Long sale_id;

    public ImportDeviceDto () {
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

    public Long getSale () {
        return sale_id;
    }

    public void setSale ( Long sale ) {
        this.sale_id = sale;
    }
}
