CREATE TABLE Users(
    id INT NOT NULL AUTO_INCREMENT ,
    fname VARCHAR(255) NOT NULL,
    lname VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

--@block

INSERT INTO users VALUES (1, 'Yassir', 'fri', 'werqwe@gmail.com','yassir123');



--@block


SELECT  * FROM users;