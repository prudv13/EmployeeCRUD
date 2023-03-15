CREATE DATABASE crudjdbcdb;
USE crudjdbcdb;
DROP DATABASE crudjdbcdb;

CREATE TABLE Employee(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    email VARCHAR(50)
);

SELECT * FROM Employee;