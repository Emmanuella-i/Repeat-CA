DROP TABLE IF EXISTS employee;


CREATE TABLE employee(employeeId int NOT NULL AUTO_INCREMENT,
             name VARCHAR(20),
             age int NOT NULL,
             hours float NOT NULL,
			 PRIMARY KEY (employeeId));



INSERT INTO employee VALUES (302, 'Kevin', 20, 35);
INSERT INTO employee VALUES (107, 'Molly', 25, 39.5);
INSERT INTO employee VALUES (222, 'Richard', 18, 40);
INSERT INTO employee VALUES (124, 'Alice', 17, 20.2);
INSERT INTO employee VALUES (322, 'Eno', 16, 12);
INSERT INTO employee VALUES (231, 'James', 30, 25.5);
INSERT INTO employee VALUES (070, 'Jen', 28, 37,3);
INSERT INTO employee VALUES (080, 'Cole', 17, 7.4);
INSERT INTO employee VALUES (090, 'Emma', 23, 28.2);
INSERT INTO employee VALUES (001, 'Samantha', 20, 16);