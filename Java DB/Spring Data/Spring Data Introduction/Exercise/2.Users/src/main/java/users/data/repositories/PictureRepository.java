package users.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import users.data.entities.Picture;

@Repository
public interface PictureRepository extends JpaRepository<Picture, Long> {
}
