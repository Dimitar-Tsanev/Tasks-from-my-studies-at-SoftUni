CREATE TABLE people (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(200) NOT NULL,
picture BLOB,
height DOUBLE(4,2),
weight DOUBLE(5,2),
gender CHAR(1) NOT NULL,
birthdate DATE NOT NULL,
biography text
);

INSERT into people (name, picture, height, weight, gender, birthdate, biography) VALUES 
('Berthe Albery', null, null, null, 'M', '1990/10/19', null),
('Kelcey Linsay', null, null, null, 'F', '1989/07/04', null),
('Enoch Thrasher', null, null, null, 'F', '1993/11/14', null),
('Nicko Carrane', null, null, null, 'M', '2000/01/12', null),
('Carlee Cossem', null, null, null, 'M', '2000/03/17', null);