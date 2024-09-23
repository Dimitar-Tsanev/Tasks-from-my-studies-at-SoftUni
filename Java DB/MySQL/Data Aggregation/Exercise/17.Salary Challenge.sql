SELECT first_name, last_name, department_id FROM employees AS e
WHERE e.salary > (
	SELECT AVG(salary) FROM employees
    GROUP BY department_id
    HAVING department_id = e.department_id
)
ORDER BY e.department_id, employee_id
LIMIT 10;