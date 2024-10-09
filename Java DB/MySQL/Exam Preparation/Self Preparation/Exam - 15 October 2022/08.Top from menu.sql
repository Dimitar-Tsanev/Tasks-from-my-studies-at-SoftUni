SELECT p.id, p.name, COUNT(op.order_id) AS count FROM products p 
JOIN orders_products op
ON p.id = op.product_id
GROUP BY op.product_id
HAVING count >= 5
ORDER BY count DESC, p.name;
