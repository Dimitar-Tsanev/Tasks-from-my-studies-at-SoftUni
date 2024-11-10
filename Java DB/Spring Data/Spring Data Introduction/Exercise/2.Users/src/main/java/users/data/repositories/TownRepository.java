package users.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import users.data.entities.Town;

@Repository
public interface TownRepository extends JpaRepository<Town, Long> {

}
