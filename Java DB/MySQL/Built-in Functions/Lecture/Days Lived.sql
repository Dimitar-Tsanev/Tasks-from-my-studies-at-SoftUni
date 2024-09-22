Select concat_ws(' ', first_name, last_name) 
	AS 'Full name', 
    TIMESTAMPDIFF(DAY, born, died)  AS '4.	Days Lived'
FROM authors;