package employees.repositories;

import employees.entities.EmployeeTaskOne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeTaskOne, Long> {

}
