DELETE FROM waiters w
WHERE id IN (
	SELECT * FROM (
		SELECT w.id FROM waiters w
		LEFT JOIN orders o
		ON w.id = o.waiter_id
		WHERE table_id IS NULL) AS wwo);
