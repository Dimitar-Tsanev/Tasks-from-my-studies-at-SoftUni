CREATE DATABASE restaurant_exam;

USE restaurant_exam;

CREATE TABLE products(
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(30) NOT NULL UNIQUE,
	type VARCHAR(30) NOT NULL,
	price DECIMAL(10,2) NOT NULL
);

CREATE TABLE clients(
	id INT AUTO_INCREMENT PRIMARY KEY,
	first_name VARCHAR(50) NOT NULL,
	last_name VARCHAR(50) NOT NULL,
	birthdate DATE NOT NULL,
	card VARCHAR(50),
	review TEXT
);

CREATE TABLE tables(
	id INT AUTO_INCREMENT PRIMARY KEY,
	floor INT NOT NULL,
	reserved BOOLEAN,
	capacity INT NOT NULL
);

CREATE TABLE waiters(
	id INT AUTO_INCREMENT PRIMARY KEY,
	first_name VARCHAR(50) NOT NULL,
	last_name VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL,
	phone VARCHAR(50),
	salary DECIMAL(10,2)
);

CREATE TABLE orders(
	id INT AUTO_INCREMENT PRIMARY KEY,
	table_id INT NOT NULL,
	waiter_id INT NOT NULL,
	order_time TIME NOT NULL,
	payed_status BOOLEAN,

	FOREIGN KEY (table_id)
	REFERENCES tables(id),

	FOREIGN KEY (waiter_id)
	REFERENCES waiters(id)
);

CREATE TABLE orders_clients(
	order_id INT,
	client_id INT,

	KEY (order_id, client_id),

	FOREIGN KEY (order_id)
	REFERENCES  orders(id),

	FOREIGN KEY (client_id )
	REFERENCES clients(id)
);

CREATE TABLE orders_products(
	order_id INT,
	product_id INT,

	KEY (order_id, product_id),

	FOREIGN KEY (order_id)
	REFERENCES  orders(id),

	FOREIGN KEY (product_id)
	REFERENCES products(id)
);
