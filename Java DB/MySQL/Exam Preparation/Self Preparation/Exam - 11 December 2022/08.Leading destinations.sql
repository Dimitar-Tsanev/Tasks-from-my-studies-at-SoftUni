SELECT c.name, c.currency, COUNT(p.id) AS booked_tickets FROM flights f
JOIN flights_passengers fp
ON f.id = fp.flight_id
JOIN passengers p
ON fp.passenger_id = p.id
JOIN countries c
ON f.destination_country = c.id
GROUP BY c.id
HAVING booked_tickets >= 20
ORDER BY booked_tickets DESC;