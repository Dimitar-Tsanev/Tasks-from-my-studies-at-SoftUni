package softuni.exam.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Star;
import softuni.exam.models.entity.enums.StarType;

import java.util.List;


@Repository
public interface StarRepository extends JpaRepository<Star, Integer> {

    boolean existsStarByName( String name );

    boolean existsStarsById(Long id);

    Star findStarById ( Long id );

    List<Star> findAllByStarTypeAndObservers_EmptyOrderByLightYearsAsc( StarType type );
}
