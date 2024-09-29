DELIMITER $$

CREATE PROCEDURE usp_raise_salaries(department_name VARCHAR(50))
BEGIN
		UPDATE employees e
        JOIN departments d
        ON e.department_id = d.department_id
        SET e.salary = e.salary * 1.05
        WHERE d.name = department_name;
END $$

DELIMITER ;

SELECT * FROM employees e
JOIN departments d
ON e.department_id = d.department_id
WHERE d.department_id = 1;

CALL usp_raise_salaries('Engineering');

SELECT * FROM employees e
JOIN departments d
ON e.department_id = d.department_id
WHERE d.department_id = 1;