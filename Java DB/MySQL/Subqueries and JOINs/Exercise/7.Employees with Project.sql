SELECT e.employee_id, e.first_name, p.name AS project_name FROM employees e
JOIN employees_projects ep
ON e.employee_id = ep.employee_id
JOIN projects p
ON  ep.project_id = p.project_id
WHERE p.end_date IS NULL AND p.start_date >= '2002-08-14'
ORDER BY e.first_name, p.name
LIMIT 5;