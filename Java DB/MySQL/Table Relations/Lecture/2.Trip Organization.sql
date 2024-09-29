SELECT driver_id, vehicle_type, concat(first_name, ' ', last_name) AS driver_name
From vehicles AS v
JOIN  campers AS c
on v.driver_id = c.id;