DELIMITER $$

CREATE PROCEDURE udp_happy_hour(type VARCHAR(50))
BEGIN
	UPDATE products p
    SET p.price = p.price * 0.8
    WHERE p.price >= 10.00 AND p.type = type;
END$$

DELIMITER ;