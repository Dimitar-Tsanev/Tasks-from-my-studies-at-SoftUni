CREATE DATABASE `gamebar` DEFAULT CHARACTER SET utf8mb4;

USE `gamebar`;

CREATE TABLE `employees` (
	`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `first_name` VARCHAR (50) NOT NULL,
    `last_name` VARCHAR(50) NOT NULL
);

CREATE TABLE `categories`(
	`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50)
);

CREATE TABLE `products`(
	`id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR (50),
    `category_id` INT NOT NULL,
    PRIMARY KEY (`id`)
);
