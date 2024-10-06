SELECT concat(UPPER(LEFT(p.last_name, 2)), country_id ) AS flight_code, 
	CONCAT_WS(' ', p.first_name, p.last_name) As full_name,
    country_id
FROM passengers p
LEFT JOIN flights_passengers fp
ON p.id = fp.passenger_id
LEFT JOIN flights f
ON fp.flight_id = f.id
WHERE f.id IS NULL
ORDER BY country_id;
