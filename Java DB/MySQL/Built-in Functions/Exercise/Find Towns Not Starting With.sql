SELECT town_id, name FROM towns
WHERE SUBSTRING(name, 1, 1) NOT IN ('r',  'b', 'd' )
ORDER BY name;