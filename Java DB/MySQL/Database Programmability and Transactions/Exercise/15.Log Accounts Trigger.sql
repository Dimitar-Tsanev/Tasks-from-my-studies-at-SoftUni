CREATE TABLE logs (
	log_id INT AUTO_INCREMENT PRIMARY KEY,
    account_id INT,
    old_sum DECIMAL(15,4),
    new_sum DECIMAL(15,4)
);

DELIMITER $$

CREATE TRIGGER tr_account_log
AFTER UPDATE
ON accounts 
FOR EACH ROW
BEGIN
	INSERT INTO logs (account_id, old_sum, new_sum) VALUES
    (OLd.id, OLD.balance, NEW.balance);
END$$

DELIMITER ;

CALL usp_transfer_money(1, 2, 10);

SELECT * FROM logs;