package game_store.data.repositories;

import game_store.data.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    @Query(value = "From Game")
    Set<Game> getAll();

    Game findByTitle(String title);

}
