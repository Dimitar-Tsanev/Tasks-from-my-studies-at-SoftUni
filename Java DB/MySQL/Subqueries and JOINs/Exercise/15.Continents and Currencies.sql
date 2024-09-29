SELECT con.continent_code,
	c.currency_code, 
	COUNT(c.currency_code) AS currency_usage 
FROM countries c
JOIN continents con
ON c.continent_code = con.continent_code
GROUP BY con.continent_code, c.currency_code
HAVING currency_usage = (
			SELECT count(c.currency_code) AS currency_usage 
			FROM countries c
			JOIN continents con_in
            ON c.continent_code = con_in.continent_code
			GROUP BY con_in.continent_code, c.currency_code
            Having con_in.continent_code = con.continent_code
            ORDER BY con_in.continent_code, currency_usage Desc
			LIMIT 1
) AND currency_usage > 1;
                            

					