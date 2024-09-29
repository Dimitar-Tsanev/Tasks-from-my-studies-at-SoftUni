DELIMITER $$

CREATE PROCEDURE usp_raise_salary_by_id(id INT)
BEGIN
	START TRANSACTION;
    IF ((SELECT employee_id FROM employees WHERE employee_id = id ) != id) THEN
		ROLLBACK;
    ELSE
		UPDATE employees e
        SET e.salary = e.salary * 1.05
        WHERE e.employee_id = id;
        COMMIT;
	END IF;
END $$

DELIMITER ;

SELECT employee_id, salary FROM employees WHERE employee_id = 17;

CALL usp_raise_salary_by_id(17);

SELECT employee_id, salary FROM employees WHERE employee_id = 17;