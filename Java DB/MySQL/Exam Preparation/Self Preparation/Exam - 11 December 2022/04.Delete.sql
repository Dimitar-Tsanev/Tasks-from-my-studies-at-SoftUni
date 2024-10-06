DELETE FROM flights f
WHERE f.id IN (
	SELECT c.id FROM (
		SELECT f.id FROM flights f
		LEFT JOIN flights_passengers fp
		ON fp.flight_id = f.id
		LEFT JOIN passengers p
		ON fp.passenger_id = p.id
		WHERE p.first_name is NULL
	) AS c
);
