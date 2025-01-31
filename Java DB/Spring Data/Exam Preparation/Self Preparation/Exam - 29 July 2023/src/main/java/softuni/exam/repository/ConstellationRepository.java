package softuni.exam.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Constellation;


@Repository
public interface ConstellationRepository  extends JpaRepository<Constellation, Integer> {
    boolean existsConstellationByName(String name);

}
