SELECT ds.id, ds.name, c.brand FROM driving_schools ds
JOIN cars c
ON ds.car_id = c.id
LEFT JOIN instructors_driving_schools ids
ON ds.id = ids.driving_school_id
WHERE ids.instructor_id IS NULL
ORDER BY c.brand, ds.id
LIMIT 5;
