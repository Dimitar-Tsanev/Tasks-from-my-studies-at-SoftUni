package users.data.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.hibernate.validator.constraints.Length;
import users.data.entities.annotations.Password;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(nullable = false)
    @Length(min = 4, max = 30)
    private String username;

    @Column(nullable = false)
    @Password(message = "Invalid password", minLength = 6,
              maxLength = 50,
              constraintDigit = true,
              constraintLowercase = true,
              constraintUppercase = true,
              constraintSpecialSymbol = true
    )
    private String password;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Min ( value = 1)
    @Max ( value = 120)
    private int age;

    @Email(message = "invalid email",
            regexp = "^(?<user>[A-Za-z0-9]+([-_.]?[A-Za-z0-9])*)@(?<host>[A-Za-z0-9]+([-_]?[A-Za-z0-9])*(.[A-Za-z]+)+)$")
    @Basic(optional = false)
    private String email;

    @Column(name ="registered_on",nullable = false)
    private LocalDate registeredOn;

    @Column(name ="last_time_logged_in",nullable = false)
    private LocalDateTime lasTimeLoggedIn;

    @Column(nullable = false)
    private boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "currently_living", referencedColumnName = "id")
    private Town currentlyLiving ;

    @ManyToOne
    @JoinColumn(name = "born_town ", referencedColumnName = "id")
    private Town bornTown;

    @ManyToMany()
    @JoinTable(name = "users_friends",
    joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "friend_id", referencedColumnName = "id"))
    private Set<User> friends;

    @OneToMany(mappedBy = "user", targetEntity = Album.class)
    private Set<Album> albums;

    public User () {
        this.friends = new HashSet<> ();
        this.albums = new HashSet<> ();
    }
    public User(String username, String password, String firstName, String lastName, String email) {
        this();
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getUsername () {
        return username;
    }

    public void setUsername ( String username ) {
        this.username = username;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword ( String password ) {
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail ( String email ) {
        this.email = email;
    }

    public LocalDate getRegisteredOn () {
        return registeredOn;
    }

    public void setRegisteredOn ( LocalDate registeredOn ) {
        this.registeredOn = registeredOn;
    }

    public LocalDateTime getLasTimeLoggedIn () {
        return lasTimeLoggedIn;
    }

    public void setLasTimeLoggedIn ( LocalDateTime lasTimeLoggedIn ) {
        this.lasTimeLoggedIn = lasTimeLoggedIn;
    }

    public boolean isDeleted () {
        return isDeleted;
    }

    public void setDeleted ( boolean deleted ) {
        isDeleted = deleted;
    }

    public Town getCurrentlyLiving () {
        return currentlyLiving;
    }

    public void setCurrentlyLiving ( Town currentlyLiving ) {
        this.currentlyLiving = currentlyLiving;
    }

    public Town getBornTown () {
        return bornTown;
    }

    public void setBornTown ( Town bornTown ) {
        this.bornTown = bornTown;
    }

    public Set<User> getFriends () {
        return friends;
    }

    public void setFriends ( Set<User> friends ) {
        this.friends = friends;
    }

    public Set<Album> getAlbums () {
        return albums;
    }

    public void setAlbums ( Set<Album> albums ) {
        this.albums = albums;
    }

    public String getFullName(){
        return this.firstName + " " + this.lastName;
    }
}
