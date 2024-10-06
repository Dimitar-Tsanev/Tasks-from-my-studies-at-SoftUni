DELIMITER $$

CREATE FUNCTION udf_average_lesson_price_by_city  (name VARCHAR(40))
RETURNS DECIMAL (10,2)
READS SQL DATA 
BEGIN
	RETURN (
		SELECT AVG(average_lesson_price)
		FROM driving_schools ds
        JOIN cities c
        ON ds.city_id = c.id
        WHERE c.name = name
    );
END$$

DELIMITER ;
