package bg.softuni.lecture.service;

import bg.softuni.lecture.data.entities.Account;
import bg.softuni.lecture.data.repositories.AccountRepository;
import bg.softuni.lecture.service.interfaces.AccountService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

//4.Services

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @Override
    public void createAccount ( Account account ) {
        if(accountRepository.findById ( account.getId ()) != null){
            throw new IllegalArgumentException("Account already exists!");
        }
        accountRepository.save(account);
    }

    @Override
    public void withdrawMoney ( Long id, double amount ) {
        if ( accountRepository.findById ( id ).isEmpty ( ) ) {
            throw new IllegalArgumentException ( "Account with id:" + id + "  does not exist" );
        }

        Account account = accountRepository.findById ( id ).get ( );

        BigDecimal afterWithdraw = account.getBalance ().subtract ( BigDecimal.valueOf (  amount ));

        if( afterWithdraw.compareTo ( BigDecimal.ZERO ) < 0 ) {
            throw new IllegalArgumentException ( "Insufficient funds" );
        }

        account.setBalance ( afterWithdraw);
        accountRepository.saveAndFlush ( account );
    }

    @Transactional
    @Override
    public void transferMoney ( Long fromId, Long toId, double amount ) {
        if ( accountRepository.findById ( toId).isEmpty ( ) ) {
            throw new IllegalArgumentException ( "Account with id:" + fromId + " does not exist" );
        }

        Account toAccount = accountRepository.findById ( toId).get ( );

        withdrawMoney ( fromId, amount );

        toAccount.setBalance ( toAccount.getBalance ().add ( BigDecimal.valueOf ( amount ) ) );
        accountRepository.saveAndFlush ( toAccount );

    }
}
