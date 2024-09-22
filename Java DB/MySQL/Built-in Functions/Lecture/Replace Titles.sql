SELECT REPLACE(title, 'The', '***')
	AS Title
FROM books 
WHERE LEFT(title, 3) = 'The'
ORDER BY id;