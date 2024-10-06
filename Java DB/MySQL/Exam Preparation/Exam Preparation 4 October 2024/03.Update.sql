UPDATE driving_schools ds
JOIN cities c
ON ds.city_id = c.id
SET average_lesson_price = average_lesson_price + 30
WHERE c.name = 'London' AND night_time_driving = 1;