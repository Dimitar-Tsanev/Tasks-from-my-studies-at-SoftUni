package products_shop.data.entity;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.Length;

import java.util.Set;

@Entity
@Table(name="users")
public class User extends BaseEntity{

    @Column(name = "first_name")
    private String firstName;

    @Column(nullable = false, name = "last_name")
    @Length(min = 3)
    private String lastName;

    @Basic
    private int age;

    @ManyToMany()
    @JoinTable(name = "users_friends",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id", referencedColumnName = "id"))
    private Set<User> friends;

    @OneToMany(mappedBy = "seller", targetEntity = Product.class)
    private Set<Product> soldProducts;

    @OneToMany(mappedBy = "buyer", targetEntity = Product.class)
    private  Set<Product> boughtProducts;

    public User () {
    }

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

    public int getAge () {
        return age;
    }

    public void setAge ( int age ) {
        this.age = age;
    }

    public Set<User> getFriends () {
        return friends;
    }

    public void setFriends ( Set<User> friends ) {
        this.friends = friends;
    }

    public Set<Product> getSoldProducts () {
        return soldProducts;
    }

    public void setSoldProducts ( Set<Product> soldProducts ) {
        this.soldProducts = soldProducts;
    }

    public Set<Product> getBoughtProducts () {
        return boughtProducts;
    }

    public void setBoughtProducts ( Set<Product> boughtProducts ) {
        this.boughtProducts = boughtProducts;
    }

    @Override
    public boolean equals ( Object o ) {
        if ( o == null || getClass ( ) != o.getClass ( ) ) return false;

        User user = (User) o;
        return lastName.equals ( user.lastName );
    }

    @Override
    public int hashCode () {
        return lastName.hashCode ( );
    }
}
