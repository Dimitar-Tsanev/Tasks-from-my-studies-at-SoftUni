package bg.softuni.lecture.data.repositories;

import bg.softuni.lecture.data.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//3.Repositories

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findById(long id);
}

