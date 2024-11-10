package users.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import users.data.entities.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}
