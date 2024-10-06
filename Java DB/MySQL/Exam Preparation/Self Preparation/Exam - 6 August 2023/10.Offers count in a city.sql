DELIMITER $$

CREATE FUNCTION udf_offers_from_city_name (cityName VARCHAR(50))
RETURNS INT
READS SQL DATA
BEGIN
	RETURN(
		SELECT COUNT(*) FROM properties p
		JOIN property_offers po
        ON p.id = po.property_id
        JOIN cities c 
        ON p.city_id = c.id
        WHERE c.name = cityName
    );
END$$

DELIMITER ;

	