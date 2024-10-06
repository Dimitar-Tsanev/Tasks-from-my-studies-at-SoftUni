DELIMITER $$

CREATE PROCEDURE usp_transfer_money(from_account_id INT, to_account_id INT,  money_amount DOUBLE) 
BEGIN
	START TRANSACTION;
		IF (money_amount <= 0)
			 THEN ROLLBACK;
        ELSEIF (1 != (SELECT Count(id) FROM accounts WHERE id = from_account_id)
				OR 1 != (SELECT Count(id) FROM accounts WHERE id = to_account_id))
			THEN ROLLBACK;
		ELSEIF (money_amount > (SELECT balance FROM accounts WHERE id = from_account_id))
			THEN ROLLBACK;
        ELSE
			UPDATE accounts
            SET balance = balance - money_amount
            WHERE  id = from_account_id;
            
            UPDATE accounts
            SET balance = balance + money_amount
            WHERE  id = to_account_id;
            COMMIT;
        END IF;
END$$

DELIMITER ; 

CALL usp_transfer_money(1, 2, 10);

SELECT * FROM accounts;