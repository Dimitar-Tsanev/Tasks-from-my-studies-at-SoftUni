SELECT CONCAT_WS(' ', a.first_name, a.last_name) AS full_name,
	CONCAT(reverse(a.last_name),char_length(a.last_name), '@cast.com') AS email,
    2022 - year(a.birthdate) AS age,
    a.height
FROM actors a
LEFT JOIN movies_actors ma
ON a.id = ma.actor_id
WHERE ma.movie_id IS NULL
ORDER BY a.height;