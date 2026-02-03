-- DROP SCHEMA pretask; 
CREATE SCHEMA pretask;
USE pretask;

CREATE TABLE product
(
	ID int auto_increment PRIMARY KEY,
    TITLE varchar(40),
	IMAGE varchar(255),
    PRICE int
);

ALTER TABLE product ADD COLUMN USERID BIGINT;

SELECT * FROM product;

CREATE TABLE users
(
	USERID int auto_increment PRIMARY KEY,
    USERNAME varchar(40),
    PASSWORD varchar(40),
    EMAIL varchar(40),
	ROLE varchar(40)
);

SELECT * FROM users;