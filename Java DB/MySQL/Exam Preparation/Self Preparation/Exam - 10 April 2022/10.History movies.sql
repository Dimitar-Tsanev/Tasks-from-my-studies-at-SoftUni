DELIMITER $$

CREATE FUNCTION udf_actor_history_movies_count(full_name VARCHAR(50)) 
RETURNS INT
READS SQL DATA
BEGIN
	RETURN(
		SELECT COUNT(ma.movie_id) FROM actors a
		JOIN movies_actors ma
        ON a.id = ma.actor_id
        JOIN genres_movies gm
        ON ma.movie_id = gm.movie_id
        JOIN genres g
        On gm.genre_id = g.id
        WHERE CONCAT_WS(' ', a.first_name, a.last_name) = full_name 
			AND g.name = 'history'
    );
END$$

DELIMITER ;

SELECT COUNT(ma.movie_id) FROM actors a
		JOIN movies_actors ma
        ON a.id = ma.actor_id
        JOIN genres_movies gm
        ON ma.movie_id = gm.movie_id
        JOIN genres g
        On gm.genre_id = g.id
        WHERE CONCAT_WS(' ', a.first_name, a.last_name) = 'Stephan Lundberg'
			AND g.name = 'history';