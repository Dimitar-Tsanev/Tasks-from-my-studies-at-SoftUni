SELECT c.name, COUNT(ids.instructor_id) AS instructors_count
FROM instructors_driving_schools ids
JOIN driving_schools ds
ON ids.driving_school_id = ds.id
JOIN cities c
ON ds.city_id = c.id
GROUP BY ds.city_id
ORDER BY instructors_count DESC;