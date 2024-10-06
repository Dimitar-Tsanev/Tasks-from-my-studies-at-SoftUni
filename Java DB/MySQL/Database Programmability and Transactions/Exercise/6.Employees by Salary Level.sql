DELIMITER $$

CREATE PROCEDURE usp_get_employees_by_salary_level ( salary_level VARCHAR(10))
BEGIN
	SELECT first_name, last_name FROM employees e
    WHERE 
		 CASE 
			WHEN lower(salary_level) = 'low' THEN e.salary < 30000
            WHEN lower(salary_level) = 'average' THEN e.salary BETWEEN 30000 AND 50000
            WHEN lower(salary_level) = 'high' THEN e.salary > 50000
		END
    ORDER BY first_name DESC, last_name DESC;
END $$

DELIMITER ;

CALL usp_get_employees_by_salary_level('low');
