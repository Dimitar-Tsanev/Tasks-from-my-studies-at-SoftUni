CREATE DATABASE car_rental;

USE car_rental;

CREATE TABLE categories (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
category VARCHAR(30),
daily_rate DOUBLE(10,2),
weekly_rate DOUBLE (10,2), 
monthly_rate DOUBLE (10,2),  
weekend_rate DOUBLE (10,2) 
);

CREATE TABLE cars (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
plate_number VARCHAR(10) NOT NULL, 
make VARCHAR(20) NOT NULL,
model VARCHAR(50) NOT NULL, 
car_year YEAR, 
category_id INT NOT NULL, 
doors INT, 
picture BLOB, 
car_condition VARCHAR(10), 
available BOOLEAN NOT NULL
);

CREATE TABLE employees (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
first_name VARCHAR(20) NOT NULL, 
last_name VARCHAR(20) NOT NULL, 
title VARCHAR(50) NOT NULL, 
notes TEXT
);

CREATE TABLE customers (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
driver_licence_number INT NOT NULL, 
full_name VARCHAR(50) NOT NULL, 
address VARCHAR(50) NOT NULL, 
city VARCHAR(20) NOT NULL, 
zip_code INT, 
notes TEXT
);

CREATE TABLE rental_orders (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
employee_id INT NOT NULL, 
customer_id  INT NOT NULL, 
car_id  INT NOT NULL, 
car_condition VARCHAR(10), 
tank_level DOUBLE (4,2), 
kilometrage_start INT, 
kilometrage_end INT, 
total_kilometrage INT, 
start_date DATE, 
end_date DATE, 
total_days INT, 
rate_applied DOUBLE(10,2), 
tax_rate DOUBLE (10,2), 
order_status VARCHAR(10), 
notes TEXT
);

INSERT INTO categories (category, daily_rate, weekly_rate, monthly_rate, weekend_rate) VALUES
('Minivan', 15.5, 100.00, 350.50, 18.5),
('Bus', NULL, 240.00, 900.00, NULL),
('Camper', 25.00, 159.99, 640.00, 35.99);

INSERT INTO cars (plate_number, make, model, car_year, category_id, doors, picture, car_condition, available) VALUES
('CL9685CA', 'Chevrolet', 'Avalanche 2500', 2005, 1, 1, null, 'accumsan', false),
('GN5991EX', 'Maserati', 'GranTurismo', 2012, 2, 2, null, 'donec', true),
('WN5829FH', 'Audi', '4000s Quattro', 1986, 3, 3, null, 'lacus', false);

INSERT INTO employees (first_name, last_name, title, notes) VALUES
('Gabriel', 'Pimme', 'Assistant', null),
('Alyosha', 'Bottlestone', 'Assistant', null),
('Waldo', 'Downe', 'Engineer', null);

INSERT INTO customers (driver_licence_number, full_name, address, city, zip_code, notes) VALUES
('8204103', 'Robenia Kolakovic', 'Redwing', 'Brniště', '47129', null),
('9695517', 'Bennett Lennarde', 'Luster', 'West Island', null, null),
('6314231', 'Jamey Robertucci', 'Towne', 'Austin', '78732', null);

INSERT INTO rental_orders (employee_id, customer_id, car_id, car_condition, tank_level, kilometrage_start, 
							kilometrage_end, total_kilometrage, start_date, end_date, total_days, rate_applied,
                            tax_rate, order_status, notes) VALUES
(1, 1, 1, 'accumsan', 2, 200230, 200250, 20, '2024-09-03', '2024-09-04', 1, 15.5, 15.5, 'some', null),
(2, 2, 2, 'donec', 10, 400230, 400350, 120, '2024-05-10', '2024-05-17', 7, 240.00, 240.00, 'some', null),
(3, 3, 3, 'lacus', 35, 200530, 200850, 320, '2024-05-10', '2024-06-10', 30, 640.00, 640.00, 'some', null);
