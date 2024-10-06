DELIMITER $$

CREATE PROCEDURE udp_find_school_by_car (target_brand VARCHAR(20))
BEGIN
	SELECT name, average_lesson_price FROM driving_schools ds
    JOIN cars c
    ON ds.car_id = c.id
    WHERE brand = target_brand
    ORDER BY average_lesson_price DESC;
END$$

DELIMITER ;