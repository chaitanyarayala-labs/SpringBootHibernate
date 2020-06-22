DROP TABLE IF EXISTS customer;

CREATE TABLE customer (
    id int AUTO_INCREMENT PRIMARY KEY,
    first_name varchar(250) NOT NULL,
    last_name varchar(250) NOT NULL
);