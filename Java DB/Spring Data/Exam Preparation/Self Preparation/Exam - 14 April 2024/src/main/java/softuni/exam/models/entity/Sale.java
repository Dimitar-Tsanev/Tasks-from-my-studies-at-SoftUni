package softuni.exam.models.entity;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sales")
public class Sale extends BaseEntity {

    @Basic
    private Boolean discounted;

    @Column(nullable = false, unique = true)
    private String number;

    @Column(name = "sale_date", nullable = false)
    private LocalDateTime saleDate;

    @ManyToOne
    @JoinColumn(name = "seller_id", referencedColumnName = "id")
    private Seller seller;

    @OneToMany(mappedBy = "sale",targetEntity = Device.class)
    private Set<Device> devices;
    public Sale() {
        devices = new HashSet<> ();
    }

    public boolean isDiscounted () {
        return discounted;
    }

    public void setDiscounted ( boolean discounted ) {
        this.discounted = discounted;
    }

    public String getNumber () {
        return number;
    }

    public void setNumber ( String number ) {
        this.number = number;
    }

    public LocalDateTime getSaleDate () {
        return saleDate;
    }

    public void setSaleDate ( LocalDateTime saleDate ) {
        this.saleDate = saleDate;
    }

    public Seller getSeller () {
        return seller;
    }

    public void setSeller ( Seller seller ) {
        this.seller = seller;
    }

    public Set<Device> getDevices () {
        return devices;
    }

    public void setDevices ( Set<Device> devices ) {
        this.devices = devices;
    }
}
