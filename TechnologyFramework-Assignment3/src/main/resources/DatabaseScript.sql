CREATE DATABASE shopping_cart;

USE shopping_cart;

CREATE TABLE IF NOT EXISTS products (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    price FLOAT NOT NULL,
    description VARCHAR(500) NOT NULL,
    imageUrl VARCHAR(100) NOT NULL
);