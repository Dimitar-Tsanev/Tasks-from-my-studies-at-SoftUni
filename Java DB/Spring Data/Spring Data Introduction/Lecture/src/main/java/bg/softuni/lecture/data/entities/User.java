package bg.softuni.lecture.data.entities;

import jakarta.persistence.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

//2.Database Models

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private int age;

    @OneToMany(mappedBy = "user", targetEntity = Account.class, fetch = FetchType.EAGER)
    private Set<Account> accounts;

    public User () {
        this.accounts = setAccounts ( );
    }

    public User ( String username, int age ) {
        setUsername ( username );
        setAge ( age );
        this.accounts = setAccounts ( );
    }

    public User ( String username, int age, Set<Account> accounts ) {
       setUsername ( username );
        setAge ( age );
        setAccounts (accounts);
    }

    public long getId () {
        return id;
    }

    public String getUsername () {
        return username;
    }

    public void setUsername ( String username ) {
        this.username = username;
    }

    public int getAge () {
        return age;
    }

    public void setAge ( int age ) {
        this.age = age;
    }

    public Set<Account> getAccounts () {
        return Collections.unmodifiableSet ( accounts );
    }

    private Set<Account> setAccounts () {
        return this.accounts = new HashSet<> ( );
    }
    private void setAccounts ( Set<Account> accounts ) {
        if ( accounts == null ) {
            setAccounts ();
        }
        this.accounts = accounts;
    }

    public void addAccount ( Account account ) {
        this.accounts.add ( account );
    }
}
