package game_store.data.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(unique = true)
    private String email;

    @Column(name = "password")
    private String passwordHash;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(nullable = false, name="is_admin")
    private boolean isAdmin;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_games",
    joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "game_id", referencedColumnName = "id"))
    private Set<Game> games;

   @OneToOne(targetEntity = ShoppingCart.class,fetch = FetchType.EAGER)
    private ShoppingCart shoppingCart;

    public User () {
        this.games = new HashSet<> ();
    }

    public String getEmail () {
        return email;
    }

    public void setEmail ( String email ) {
        this.email = email;
    }

    public String getPasswordHash () {
        return passwordHash;
    }

    public void setPasswordHash ( String passwordHash ) {
        this.passwordHash = passwordHash;
    }

    public String getFullName () {
        return fullName;
    }

    public void setFullName ( String fullName ) {
        this.fullName = fullName;
    }

    public boolean isAdmin () {
        return isAdmin;
    }

    public void setAdmin ( boolean admin ) {
        isAdmin = admin;
    }

    public Set<Game> getGames () {
        return games;
    }

    public void setGames ( Set<Game> games ) {
        this.games = games;
    }

    public ShoppingCart getShoppingCart () {
        return shoppingCart;
    }

    public void setShoppingCart ( ShoppingCart shoppingCart ) {
        this.shoppingCart = shoppingCart;
    }
    public void addGames ( Set<Game> game ) {
        this.games.addAll (game);
    }
}
