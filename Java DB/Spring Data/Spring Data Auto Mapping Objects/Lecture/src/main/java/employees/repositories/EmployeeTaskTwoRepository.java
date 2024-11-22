package employees.repositories;

import employees.entities.EmployeeTaskTwo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Set;

@Repository
public interface EmployeeTaskTwoRepository extends JpaRepository<EmployeeTaskTwo, Long> {

    @Query(value = "select m from EmployeeTaskTwo e JOIN e.manager m")
    Set<EmployeeTaskTwo> findAllManager();

    Set<EmployeeTaskTwo> findAllByBirthDateBefore( LocalDate birthDate);
}
