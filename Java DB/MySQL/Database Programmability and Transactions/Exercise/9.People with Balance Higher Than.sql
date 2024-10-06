DELIMITER $$

CREATE PROCEDURE usp_get_holders_with_balance_higher_than(searched_number DOUBLE(15,4))
BEGIN
	SELECT first_name, last_name FROM account_holders ah
	JOIN accounts a
	ON ah.id = a.account_holder_id
	GROUP BY account_holder_id
	HAVING SUM(balance) > searched_number
	ORDER BY ah.id;
END$$

DELIMITER ;

CALL usp_get_holders_with_balance_higher_than(7000);


