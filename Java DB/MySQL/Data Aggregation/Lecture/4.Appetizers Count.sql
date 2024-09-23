SELECT count(*) FROM products
WHERE price > 8 AND category_id = (SELECT id FROM categories WHERE name = 'appetizers');
