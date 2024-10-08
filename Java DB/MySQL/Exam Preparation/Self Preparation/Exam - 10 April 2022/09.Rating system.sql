SELECT m.title, 
	CASE
		WHEN mai.rating <= 4 THEN 'poor'
		WHEN mai.rating <= 7 THEN 'good'
        ELSE 'excellent'
    END AS rating,
    IF(mai.has_subtitles, 'english', '-') AS subtitles,
    mai.budget
FROM movies_additional_info mai
JOIN movies m
ON mai.id = m.movie_info_id
ORDER BY mai.budget DESC;