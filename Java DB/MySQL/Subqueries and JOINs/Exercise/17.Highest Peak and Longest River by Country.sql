SELECT c.country_name, 
	MAX(p.elevation) AS highest_peak_elevation,
    MAX(r.length) AS longest_river_length 
FROM countries c
JOIN countries_rivers cr
ON c.country_code = cr.country_code
JOIN rivers r
ON cr.river_id = r.id
JOIN mountains_countries mc
ON c.country_code = mc.country_code
JOIN peaks p
ON mc.mountain_id = p.mountain_id
GROUP BY c.country_name
ORDER BY highest_peak_elevation DESC, longest_river_length DESC, c.country_name
LIMIT 5;