DELIMITER $$

CREATE PROCEDURE udp_increase_salaries_by_country (country_name VARCHAR(40))
BEGIN
	UPDATE workers w
    JOIN preserves p
	ON w.preserve_id = p.id
	JOIN countries_preserves cp
	ON p.id = cp.preserve_id
	JOIN countries c
	ON cp.country_id = c.id
    SET salary = salary * 1.05
    WHERE country_name = c.name;
END$$

DELIMITER ;
