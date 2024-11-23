package game_store.data.entities;

import jakarta.persistence.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "shopping carts")
public class ShoppingCart extends BaseEntity {

    @OneToOne
    private User user;

    @ManyToMany
    @JoinTable(
            name = "shopping_carts_games",
            joinColumns = @JoinColumn(name = "shopping_cart_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "game_id", referencedColumnName = "id")
    )
    private final Set<Game> games;

    public ShoppingCart() {
        games = new HashSet<> ();
    }
    public ShoppingCart(User user) {
        this();
        this.user = user;
    }

    public User getUser () {
        return user;
    }

    public void setUser ( User user ) {
        this.user = user;
    }

    public Set<Game> getGames () {
        return Collections.unmodifiableSet ( this.games);
    }

    public void addGames ( Game game ) {
        this.games.add ( game);
    }

    public void removeGame ( Game game ) {
        this.games.remove ( game);
    }

    public void buyItems (  ) {
        this.user.addGames ( this.games );
        this.games.clear ();
    }
}
