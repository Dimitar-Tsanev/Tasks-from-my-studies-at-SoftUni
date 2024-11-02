package bg.softuni.lecture.controler;

import bg.softuni.lecture.data.entities.Account;
import bg.softuni.lecture.data.entities.User;
import bg.softuni.lecture.data.repositories.UserRepository;
import bg.softuni.lecture.service.interfaces.AccountService;
import bg.softuni.lecture.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Set;

//5.ConsoleRunner and Application

@Component
public class ConsoleRunner implements CommandLineRunner {
    private UserService userService;
    private AccountService accountService;

    @Autowired
    public ConsoleRunner( UserService userService, AccountService accountService, UserRepository userRepository ) {
        this.userService = userService;
        this.accountService = accountService;

    }

    @Override
    public void run ( String... args ) throws Exception {
        //6.Test

        User user;
        Account account;
        Account account2;

        try {
            user = new User("Random", 20);

            account = new Account(user);
            account2 = new Account(user);

            account.setBalance ( BigDecimal.valueOf (  2000 ) );
            account2.setBalance ( BigDecimal.valueOf (  2000 ) );

            user.addAccount ( account );
            user.addAccount ( account2 );

            userService.registerUser ( user );

            accountService.createAccount ( account );
            accountService.createAccount ( account2 );


        } catch (IllegalArgumentException e) {
           user = userService.findUserByUsername ( "Random" );

           Set<Account> accounts = user.getAccounts ();
           account = accounts.iterator ().next ();
           account2 = accounts.iterator ().next ();
        }

        accountService.transferMoney ( account.getId (), account2.getId (), 1000 );
        accountService.withdrawMoney ( account.getId (), 1000 );
    }
}
