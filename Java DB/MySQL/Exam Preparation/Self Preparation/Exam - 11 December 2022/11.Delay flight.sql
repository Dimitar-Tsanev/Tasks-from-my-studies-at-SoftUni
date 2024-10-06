DELIMITER $$

CREATE PROCEDURE udp_delay_flight (delayed_flight VARCHAR(50))
BEGIN
	UPDATE flights f
    SET has_delay = TRUE
    WHERE flight_code = delayed_flight;
    
    UPDATE flights f
    SET departure = ADDTIME(departure, '00:30:00' )
    WHERE flight_code = delayed_flight;
END$$

DELIMITER ;