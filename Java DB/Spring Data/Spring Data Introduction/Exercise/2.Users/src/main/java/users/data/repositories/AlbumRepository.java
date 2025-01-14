package users.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import users.data.entities.Album;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {

}
