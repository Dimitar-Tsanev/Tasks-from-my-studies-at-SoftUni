package bg.softuni.lecture.service.interfaces;


import bg.softuni.lecture.data.entities.Account;

public interface AccountService {

    void createAccount( Account account);

    void withdrawMoney( Long id, double amount);
    void transferMoney ( Long fromId, Long toID, double amount);
}
