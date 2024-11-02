package bg.softuni.lecture.data.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

//2.Database Models

@Entity
@Table (name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private BigDecimal balance;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    public Account () {
        this.balance = BigDecimal.ZERO;
    }
    public Account (User user){
        this.user = user;
    }

    public long getId () {
        return id;
    }

    public BigDecimal getBalance () {
        return balance;
    }

    public void setBalance ( BigDecimal balance ) {
        this.balance = balance;
    }

    public User getUser () {
        return user;
    }

    public void setUser ( User user ) {
        this.user = user;
    }
}
