CREATE SCHEMA  soft_uni;

USE soft_uni;

CREATE TABLE towns (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
name VARCHAR(20) NOT NULL
);

CREATE TABLE addresses (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
address_text VARCHAR(50) NOT NULL, 
town_id INT,
CONSTRAINT fk_town_id
FOREIGN KEY (town_id) REFERENCES towns (id)
);

CREATE TABLE departments (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
name VARCHAR(50) NOT NULL
);

CREATE TABLE employees (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
first_name VARCHAR(20) NOT NULL, 
middle_name VARCHAR(20) NOT NULL, 
last_name VARCHAR(20) NOT NULL, 
job_title VARCHAR(50) NOT NULL, 
department_id INT NOT NULL,
hire_date DATE NOT NULL, 
salary DOUBLE (10,2), 
address_id INT NOT NULL,
CONSTRAINT fk_department_id_address_id
FOREIGN KEY (department_id) REFERENCES departments (id),
FOREIGN KEY (address_id) REFERENCES addresses (id)
);

INSERT INTO towns (name) VALUES 
('Sofia'), 
('Plovdiv'),
('Varna'),
('Burgas');

INSERT INTO addresses (address_text, town_id) VALUES 
('ul. krum popov 75', 1),
('ul. aleksandar raichenski 5', 3),
('ul. soflu 11', 2),
('ul. tsar kalojn 142a', 4),
('ul. william gladstone 28', 1);

INSERT INTO departments(name) VALUES
('Engineering'),
('Sales'),
('Marketing'),
('Software Development'),
('Quality Assurance');

INSERT INTO employees (first_name, middle_name, last_name, job_title, department_id, hire_date, salary, address_id) VALUES
('Ivan', 'Ivanov', 'Ivanov', '.NET Developer', 4, '2013-02-01', 3500.00,1),
('Petar', 'Petrov', 'Petrov', 'Senior Engineer', 1, '2004-03-02', 4000.00,2),
('Maria', 'Petrova', 'Ivanova', 'Intern', 5, '2016-08-28', 525.25,3),
('Georgi', 'Terziev', 'Ivanov', 'CEO', 2, '2007-12-09', 3000.00,4),
('Peter', 'Pan', 'Pan', 'Intern', 3, '2016-08-28', 599.88,5);


