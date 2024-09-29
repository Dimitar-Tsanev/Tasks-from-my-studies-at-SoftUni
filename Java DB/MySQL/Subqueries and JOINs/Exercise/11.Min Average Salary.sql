SELECT MIN(avg_salary) min_average_salary
FROM (
	SELECT AVG(salary) AS avg_salary  FROM employees
    GROUP BY department_id
) AS min_average_salary;