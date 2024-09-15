CREATE TABLE users (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
username VARCHAR(30) NOT NULL ,
password VARCHAR(26) NOT NULL,
profile_picture TEXT,
last_login_time DATETIME,
is_deleted BOOLEAN
);

INSERT INTO users (username, password, profile_picture, last_login_time, is_deleted) VALUES
('tledgley0', 'uN9+2x1S+m0<g)', null, '2024-09-03 7:49', false),
('gimpy1', 'sA4/,%9/i*!.0&', null, '2024-01-28 4:41', false),
('zlubomirski2', 'bY6#a2oT%TDA5w.5', null, '2024-03-03 5:37', true),
('jcrouch3', 'iA0++RKk', null, '2024-01-22 12:41', true),
('sbernardotti4', 'oU3&k6jZl?fPD*ZV', null, '2024-02-23 6:02', true);