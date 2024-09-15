CREATE DATABASE Movies;

USE Movies;

CREATE TABLE directors (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
director_name VARCHAR(100) NOT NULL,
notes TEXT
);

CREATE TABLE genres (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
genre_name VARCHAR(100) NOT NULL,
notes TEXT
); 

CREATE TABLE categories (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
category_name VARCHAR(100) NOT NULL,
notes TEXT
) ;

CREATE TABLE movies 
(id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
title VARCHAR(100) NOT NULL,
director_id INT NOT NULL , 
copyright_year YEAR NOT NULL,
length DOUBLE NOT NULL,
genre_id int NOT NULL,
category_id INT NOT NULL,
rating DOUBLE, 
notes TEXT
);

INSERT INTO directors (director_name) VALUES
('Ruperto Slyne'),
('Charmane Kardos'),
('Alyda Moncrieffe'),
('Heath Lipman'),
('Dougie Bette');

INSERT INTO genres (genre_name) VALUES
('Drama|Romance|War'),
('Horror'),
('Drama'),
('Documentary'),
('Children|Drama');

INSERT INTO categories (category_name) VALUES
('Children'),
('Adult'),
('Family'),
('18+'),
('12+');

INSERT INTO movies (title, director_id, copyright_year, length, genre_id, category_id, rating, notes)
VALUES 
('Mental Disorder', 4, 1952, 2.23, 2, 4, null, 'some'),
('Shoots', 1, 1995, 1.8, 1, 5, null, 'text'),
('Adventure', 3, 1992, 2.1, 4, 3, null, null),
('Sad bunny', 2, 1999, 1.5, 5, 1, null, 'some'),
('Crime', 5, 2002, 2.15, 3, 2, null, 'some');