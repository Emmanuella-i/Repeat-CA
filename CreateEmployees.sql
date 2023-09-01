DROP TABLE IF EXISTS employee;


CREATE TABLE employee(employeeId int NOT NULL AUTO_INCREMENT,
             name VARCHAR(20),
             hours float NOT NULL AUTO_INCREMENT,
			 PRIMARY KEY (employeeId));



INSERT INTO employee VALUES (302, 'Kevin', 35);
INSERT INTO employee VALUES (107, 'Molly', 39.5);
INSERT INTO employee VALUES (222, 'Richard', 40);
INSERT INTO employee VALUES (124, 'Alice', 20.2);
INSERT INTO employee VALUES (322, 'Eno', 12);
INSERT INTO employee VALUES (231, 'James', 25.5);
INSERT INTO employee VALUES (070, 'Jen', 37,3);
INSERT INTO employee VALUES (080, 'Cole', 7.4);
INSERT INTO employee VALUES (090, 'Emma', 28.2);
INSERT INTO employee VALUES (001, 'Samantha', 16);