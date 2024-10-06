DELIMITER $$

CREATE PROCEDURE udp_special_offer (agent_first_name VARCHAR(50))
BEGIN
	UPDATE property_offers po
    JOIN agents a
    ON po.agent_id = a.id
    SET po.price = price * 0.9
    WHERE a.first_name = agent_first_name;
END$$

DELIMITER ;

	SELECT a.first_name, po.price FROM property_offers po
    JOIN agents a
    ON po.agent_id = a.id
    
    WHERE a.first_name = 'hans';