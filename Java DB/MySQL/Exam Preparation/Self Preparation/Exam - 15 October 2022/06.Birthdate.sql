SELECT first_name, last_name, birthdate, review FROM clients
WHERE (YEAR(birthdate) BETWEEN 1978 AND 1993) 
	AND (card IS NULL)
ORDER BY last_name DESC, id
LIMIT 5;