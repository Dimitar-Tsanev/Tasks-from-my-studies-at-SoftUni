USE soft_uni;

DELIMITER $$

CREATE FUNCTION ufn_calculate_future_value (sum DOUBLE(12,4), interest_rate DOUBLE(5,4), years INT )
RETURNS DECIMAL(15,4)
NO SQL
BEGIN 
	RETURN (sum * POW(1 + interest_rate, years));
END$$

DELIMITER ;

SELECT ufn_calculate_future_value (1000, 0.5, 5);