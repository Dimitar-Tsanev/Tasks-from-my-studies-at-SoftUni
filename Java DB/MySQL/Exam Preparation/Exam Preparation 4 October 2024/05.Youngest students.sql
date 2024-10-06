SELECT CONCAT_WS(' ', first_name, last_name) AS full_name, age
FROM students
WHERE age = (SELECT age From students ORDER BY age LIMIT 1) 
	AND first_name LIKE '%a%';