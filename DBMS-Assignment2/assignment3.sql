CREATE DATABASE IF NOT EXISTS e_commerce;

USE e_commerce;

/*products table structure */
CREATE TABLE IF NOT EXISTS products (
    product_id INT PRIMARY KEY,
    name VARCHAR(30) NOT NULL
);

CREATE TABLE IF NOT EXISTS category (
    product_id INT PRIMARY KEY,
    category_id INT,
    CONSTRAINT category_fk_product_id
    FOREIGN KEY(product_id) REFERENCES products(product_id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT category_fk_category_id
    FOREIGN KEY(category_id) REFERENCES products(product_id) ON DELETE CASCADE ON UPDATE CASCADE
);


/*Insertion in products table*/
INSERT INTO products(product_id, name) 
VALUES(101, "Mobiles & Tablets");

INSERT INTO products(product_id, name) 
VALUES(102, "Mobiles");

INSERT INTO products(product_id, name) 
VALUES(103, "Tablets");

INSERT INTO products(product_id, name) 
VALUES(104, "Accessories");

INSERT INTO products(product_id, name) 
VALUES(105, "Cases & Covers");

INSERT INTO products(product_id, name) 
VALUES(106, "Smart Phones");

INSERT INTO products(product_id, name) 
VALUES(107, "Featured Phones");

INSERT INTO products(product_id, name) 
VALUES(108, "2G");

INSERT INTO products(product_id, name) 
VALUES(109, "3G");

INSERT INTO products(product_id, name) 
VALUES(110, "Computers");

INSERT INTO products(product_id, name) 
VALUES(111, "Desktok");

INSERT INTO products(product_id, name) 
VALUES(112, "Laptop");

INSERT INTO products(product_id, name) 
VALUES(113, "Laptop Accessories");

INSERT INTO products(product_id, name) 
VALUES(114, "Printers");

INSERT INTO products(product_id, name) 
VALUES(115, "Keyboard");

INSERT INTO products(product_id, name) 
VALUES(116, "Mouse");

INSERT INTO products(product_id, name) 
VALUES(117, "Headphones");

INSERT INTO products(product_id, name) 
VALUES(118, "Inkjet");

INSERT INTO products(product_id, name) 
VALUES(119, "Laser");

INSERT INTO products(product_id, name) 
VALUES(120, "Home Appliances");

INSERT INTO products(product_id, name) 
VALUES(121, "TVs");

INSERT INTO products(product_id, name) 
VALUES(122, "Air Conditioners");

INSERT INTO products(product_id, name) 
VALUES(123, "Washing Machines");

INSERT INTO products(product_id, name) 
VALUES(124, "LED");

INSERT INTO products(product_id, name) 
VALUES(125, "LCD");

INSERT INTO products(product_id, name) 
VALUES(126, "Plasma");

INSERT INTO products(product_id, name) 
VALUES(127, "Full Automatic");

INSERT INTO products(product_id, name) 
VALUES(128, "Semi Automatic");

INSERT INTO products(product_id, name) 
VALUES(129, "Top Load");

INSERT INTO products(product_id, name) 
VALUES(130, "Front Load");

/* Insertion into category table*/
INSERT INTO category(product_id, category_id) 
VALUES(102, 101);

INSERT INTO category(product_id, category_id) 
VALUES(103, 101);

INSERT INTO category(product_id, category_id) 
VALUES(104, 101);

INSERT INTO category(product_id, category_id) 
VALUES(105, 101);

INSERT INTO category(product_id, category_id) 
VALUES(106, 102);

INSERT INTO category(product_id, category_id) 
VALUES(107, 102);

INSERT INTO category(product_id, category_id) 
VALUES(108, 103);

INSERT INTO category(product_id, category_id) 
VALUES(109, 103);

INSERT INTO category(product_id, category_id) 
VALUES(111, 110);

INSERT INTO category(product_id, category_id) 
VALUES(112, 110);

INSERT INTO category(product_id, category_id) 
VALUES(113, 110);

INSERT INTO category(product_id, category_id) 
VALUES(114, 110);

INSERT INTO category(product_id, category_id) 
VALUES(115, 113);

INSERT INTO category(product_id, category_id) 
VALUES(116, 113);

INSERT INTO category(product_id, category_id) 
VALUES(117, 113);

INSERT INTO category(product_id, category_id) 
VALUES(118, 114);

INSERT INTO category(product_id, category_id) 
VALUES(119, 114);

INSERT INTO category(product_id, category_id) 
VALUES(121, 120);

INSERT INTO category(product_id, category_id) 
VALUES(122, 120);

INSERT INTO category(product_id, category_id) 
VALUES(123, 120);

INSERT INTO category(product_id, category_id) 
VALUES(124, 121);

INSERT INTO category(product_id, category_id) 
VALUES(125, 121);

INSERT INTO category(product_id, category_id) 
VALUES(126, 121);

INSERT INTO category(product_id, category_id) 
VALUES(127, 123);

INSERT INTO category(product_id, category_id) 
VALUES(128, 123);

INSERT INTO category(product_id, category_id) 
VALUES(129, 127);

INSERT INTO category(product_id, category_id) 
VALUES(130, 127);



/*
display all the categories along with its Parent category, 
Result should be sorted on Parent Category,
If category is top category then it should display “Top Category” in Parent category. 
*/
SELECT p1.product_id, p1.name, IFNULL(p2.name, "Top Category") AS ParentCategory 
FROM products p1
LEFT JOIN category c USING (product_id)
LEFT JOIN products p2 
ON p2.product_id = c.category_id
ORDER BY ParentCategory;


/*Rewrite above SQL query to display only Top Categories.*/
SELECT product_id, name 
FROM products 
WHERE product_id NOT IN (SELECT product_id FROM category);
