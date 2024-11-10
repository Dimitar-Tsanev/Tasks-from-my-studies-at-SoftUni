package users.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import users.data.entities.User;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByEmailEndingWith( String emailProvider);
    Optional<User> findByEmail( String email);
    List<User> findByLasTimeLoggedInBefore( LocalDateTime time );

}
