USE soft_uni;

DELIMITER $$

CREATE FUNCTION ufn_calculate_future_value (sum DOUBLE(12,4), interest_rate DOUBLE(5,4), years INT )
RETURNS DECIMAL(15,4)
NO SQL
BEGIN 
	RETURN (sum * POW(1 + interest_rate, years));
END$$

CREATE PROCEDURE usp_calculate_future_value_for_account (account_id INT, interest_rate DOUBLE(5,4))
BEGIN
	SELECT a.id, first_name, 
			last_name,
			balance AS current_balance, 
			(SELECT UFN_CALCULATE_FUTURE_VALUE(a.balance, interest_rate, 5 )) AS balance_in_5_years
	FROM account_holders ah
	JOIN accounts a
	ON ah.id = a.account_holder_id
	WHERE a.id = account_id;
END$$

DELIMITER ;

CALL usp_calculate_future_value_for_account (1, 0.1);

