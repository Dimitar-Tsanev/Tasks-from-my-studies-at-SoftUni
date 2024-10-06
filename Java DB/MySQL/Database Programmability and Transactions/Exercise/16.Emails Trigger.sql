CREATE TABLE notification_emails(
	id INT AUTO_INCREMENT PRIMARY KEY,
	recipient INT, 
	subject VARCHAR(50),
    body TEXT
);

DELIMITER $$

CREATE TRIGGER tr_email_notification
AFTER INSERT
ON logs 
FOR EACH ROW
BEGIN
	INSERT INTO notification_emails (recipient, subject, body) VALUES
    (NEW.account_id, 
    CONCAT('Balance change for account: ', NEW.account_id),
    Concat(CONCAT_WS(' ','On', (SELECT DATE_FORMAT(NOW(), '%b %d %Y')), 'at',(SELECT DATE_FORMAT(NOW(), '%r')), 'your balance was changed from', NEW.old_sum, 'to', NEW.new_sum), '.'));
END$$

DELIMITER ;

CALL usp_transfer_money(1, 2, 10);

SELECT * FROM notification_emails;
