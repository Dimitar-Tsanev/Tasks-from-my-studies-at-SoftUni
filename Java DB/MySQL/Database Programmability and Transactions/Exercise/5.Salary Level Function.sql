DELIMITER $$

CREATE FUNCTION ufn_get_salary_level (salary DOUBLE(10,2))
RETURNS VARCHAR(10)
DETERMINISTIC
BEGIN
	RETURN (
	SELECT 
       CASE 
			WHEN salary < 30000 THEN 'Low'
            WHEN salary <= 50000 THEN 'Average'
            ELSE 'High'
		END AS salary_Level);
END $$

DELIMITER ;

SELECT ufn_get_salary_level(13500.00);