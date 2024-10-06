SELECT i.first_name, i.last_name,
	COUNT(ist.student_id) AS students_count, 
	c.name AS city
FROM instructors_students ist
JOIN instructors i
ON ist.instructor_id = i.id
JOIN instructors_driving_schools ids
ON ist.instructor_id = ids.instructor_id
JOIN driving_schools ds
ON ids.driving_school_id = ds.id
JOIN cities c
ON ds.city_id = c.id
GROUP BY ids.instructor_id, ds.id
HAVING students_count > 1
ORDER BY students_count DESC, i.first_name;