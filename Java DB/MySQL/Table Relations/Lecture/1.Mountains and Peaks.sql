CREATE TABLE mountains (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(30) NOT NULL
);

CREATE TABLE peaks (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(30) NOT NULL,
    mountain_id INT,
    CONSTRAINT fk_peaks_moutains
    FOREIGN KEY (mountain_id)
    REFERENCES mountains(id)
);