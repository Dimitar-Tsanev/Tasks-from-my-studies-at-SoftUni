DELIMITER $$

CREATE PROCEDURE usp_withdraw_money (account_id INT, money_amount DOUBLE) 
BEGIN
	START TRANSACTION;
		IF (money_amount <= 0)
			 THEN ROLLBACK;
        ELSEIF (account_id != (SELECT id FROM accounts WHERE id = account_id))
			THEN ROLLBACK;
		ELSEIF (money_amount > (SELECT balance FROM accounts WHERE id = account_id))
			THEN ROLLBACK;
        ELSE
			UPDATE accounts
            SET balance = balance - money_amount
            WHERE  id = account_id;
            COMMIT;
        END IF;
END$$

DELIMITER ; 

CALL usp_withdraw_money(1, 10);

SELECT * FROM accounts WHERE  id = 1;
