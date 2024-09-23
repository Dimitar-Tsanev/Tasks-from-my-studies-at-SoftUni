SELECT CASE
	WHEN age <= 10 Then '[0-10]'
	WHEN age <= 20 Then '[11-20]'
	WHEN age <= 30 Then '[21-30]'
	WHEN age <= 40 Then '[31-40]'
	WHEN age <= 50 Then '[41-50]'
	WHEN age <= 60 Then '[51-60]'
	WHEN age > 60 Then '[61+]'
END AS age_group,
COUNT(*) AS wizard_count
FROM wizzard_deposits
GROUP BY age_group
ORDER BY age_group;