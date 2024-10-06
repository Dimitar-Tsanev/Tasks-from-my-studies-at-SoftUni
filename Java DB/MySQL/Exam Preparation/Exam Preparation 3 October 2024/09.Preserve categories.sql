SELECT id, name,
	CASE 
		WHEN area < 101 THEN 'very small'
		WHEN area < 1001 THEN 'small'
		WHEN area < 10001 THEN 'medium'
		WHEN area < 50001 THEN 'large'
		WHEN area > 50000 THEN 'very large'
	END category
FROM preserves
ORDER BY area DESC;
