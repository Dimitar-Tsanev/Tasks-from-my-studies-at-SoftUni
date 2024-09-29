SELECT employee_id,  job_title, e.address_id, a.address_text 
FROM employees e
JOIN addresses a 
ON e.address_id = a.address_id
ORDER BY a.address_id
LIMIT 5;
