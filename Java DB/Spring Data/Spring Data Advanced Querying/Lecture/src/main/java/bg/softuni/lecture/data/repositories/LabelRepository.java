package bg.softuni.lecture.data.repositories;

import bg.softuni.lecture.data.entities.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LabelRepository extends JpaRepository<Label, Long> {
    Optional<Label> findByTitle(String name);
}
