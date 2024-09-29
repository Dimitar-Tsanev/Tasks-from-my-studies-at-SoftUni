CREATE SCHEMA management;

USE management;

CREATE TABLE clients(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    client_name VARCHAR(100)
);

CREATE TABLE employees (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(30),
	last_name VARCHAR(30),
    project_id INT
);

CREATE TABLE projects (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    client_id INT,
    project_lead_id INT,
    
    FOREIGN KEY (client_id)
    REFERENCES clients (id),
    
	FOREIGN KEY (project_lead_id)
    REFERENCES employees (id)
);

ALTER TABLE employees
ADD FOREIGN KEY (project_id)
REFERENCES projects (id);