package bg.softuni.lecture.data.repositories;

import bg.softuni.lecture.data.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//3.Repositories

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
