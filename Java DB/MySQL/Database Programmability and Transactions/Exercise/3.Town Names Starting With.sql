DELIMITER $$

CREATE PROCEDURE usp_get_towns_starting_with (town_start_with VARCHAR(50))
BEGIN
	SELECT name  AS town_name FROM towns
    WHERE name LIKE CONCAT(town_start_with, '%')
    ORDER BY name;
END $$

DELIMITER ;

CALL usp_get_towns_starting_with('b');
