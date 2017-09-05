CREATE DATABASE IF NOT EXISTS e_commerce;

USE e_commerce;

/*products table structure */
CREATE TABLE IF NOT EXISTS products (
    product_id INT PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    category_id INT
);


/*Insertion in products table*/
INSERT INTO products(product_id, name, category_id) 
VALUES(101, "Mobiles & Tablets", 0);

INSERT INTO products(product_id, name, category_id) 
VALUES(102, "Mobiles", 101);

INSERT INTO products(product_id, name, category_id) 
VALUES(103, "Tablets", 101);

INSERT INTO products(product_id, name, category_id) 
VALUES(104, "Accessories", 101);

INSERT INTO products(product_id, name, category_id) 
VALUES(105, "Cases & Covers", 101);

INSERT INTO products(product_id, name, category_id) 
VALUES(106, "Smart Phones", 102);

INSERT INTO products(product_id, name, category_id) 
VALUES(107, "Featured Phones", 102);

INSERT INTO products(product_id, name, category_id) 
VALUES(108, "2G", 103);

INSERT INTO products(product_id, name, category_id) 
VALUES(109, "3G", 103);

INSERT INTO products(product_id, name, category_id) 
VALUES(110, "Computers", 0);

INSERT INTO products(product_id, name, category_id) 
VALUES(111, "Desktok", 110);

INSERT INTO products(product_id, name, category_id) 
VALUES(112, "Laptop", 110);

INSERT INTO products(product_id, name, category_id) 
VALUES(113, "Laptop Accessories", 110);

INSERT INTO products(product_id, name, category_id) 
VALUES(114, "Printers", 110);

INSERT INTO products(product_id, name, category_id) 
VALUES(115, "Keyboard", 113);

INSERT INTO products(product_id, name, category_id) 
VALUES(116, "Mouse", 113);

INSERT INTO products(product_id, name, category_id) 
VALUES(117, "Headphones", 113);

INSERT INTO products(product_id, name, category_id) 
VALUES(118, "Inkjet", 114);

INSERT INTO products(product_id, name, category_id) 
VALUES(119, "Laser", 114);

INSERT INTO products(product_id, name, category_id) 
VALUES(120, "Home Appliances", 0);

INSERT INTO products(product_id, name, category_id) 
VALUES(121, "TVs", 120);

INSERT INTO products(product_id, name, category_id) 
VALUES(122, "Air Conditioners", 120);

INSERT INTO products(product_id, name, category_id) 
VALUES(123, "Washing Machines", 120);

INSERT INTO products(product_id, name, category_id) 
VALUES(124, "LED", 121);

INSERT INTO products(product_id, name, category_id) 
VALUES(125, "LCD", 121);

INSERT INTO products(product_id, name, category_id) 
VALUES(126, "Plasma", 121);

INSERT INTO products(product_id, name, category_id) 
VALUES(127, "Full Automatic", 123);

INSERT INTO products(product_id, name, category_id) 
VALUES(128, "Semi Automatic", 123);

INSERT INTO products(product_id, name, category_id) 
VALUES(129, "Top Load", 127);

INSERT INTO products(product_id, name, category_id) 
VALUES(130, "Front Load", 127);


/*
display all the categories along with its Parent category, 
Result should be sorted on Parent Category,
If category is top category then it should display “Top Category” in Parent category. 
*/
SELECT p1.product_id, p1.name, IFNULL(p2.name, "Top Category") AS ParentCategory 
FROM products p1
LEFT JOIN products p2 
ON p2.product_id = p1.category_id
ORDER BY ParentCategory;

/*Rewrite above SQL query to display only Top Categories.*/
SELECT product_id, name 
FROM products 
WHERE category_id = 0;
