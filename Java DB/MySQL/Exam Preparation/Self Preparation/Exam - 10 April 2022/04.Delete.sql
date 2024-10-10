DELETE FROM countries
WHERE id IN (SELECT id FROM (
	SELECT c.id FROM movies m
    RIGHT JOIN countries c
    ON c.id = m.country_id
    WHERE m.id IS NULL
    ) AS countries_without_movies);
