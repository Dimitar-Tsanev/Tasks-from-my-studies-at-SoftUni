INSERT INTO courses (name, duration_hours, start_date, teacher_name, description, university_id)
SELECT
	CONCAT_WS(' ',teacher_name, 'course'),
    CHAR_LENGTH(name) /10,
    ADDDATE(start_date, INTERVAL 5 DAY),
    REVERSE(teacher_name),
    CONCAT('Course', ' ', teacher_name, REVERSE(description)),
    DAY(start_date)
FROM courses
WHERE id <= 5;