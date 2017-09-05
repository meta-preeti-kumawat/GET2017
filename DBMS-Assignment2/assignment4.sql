CREATE DATABASE IF NOT EXISTS city_code_directory;

USE city_code_directory;

/*State table*/
CREATE TABLE IF NOT EXISTS state (
    state_id INT PRIMARY KEY,
    state_name VARCHAR(30) NOT NULL
);

/*city table*/
CREATE TABLE IF NOT EXISTS city (
    zipcode INT PRIMARY KEY,
    city_name VARCHAR(30) NOT NULL,
    state_id INT,
    CONSTRAINT city_fk_state_id
    FOREIGN KEY(state_id) REFERENCES state(state_id) ON DELETE CASCADE ON UPDATE CASCADE
);

/* Insert into states */
INSERT INTO state(state_id, state_name) VALUES(101, "Rajasthan");
INSERT INTO state(state_id, state_name) VALUES(102, "Maharastra");
INSERT INTO state(state_id, state_name) VALUES(103, "Jammu & Kashmir");
INSERT INTO state(state_id, state_name) VALUES(104, "Himachal Pradesh");
INSERT INTO state(state_id, state_name) VALUES(105, "Madhya Pradesh");
INSERT INTO state(state_id, state_name) VALUES(106, "Karnataka");
INSERT INTO state(state_id, state_name) VALUES(107, "Kerala");
INSERT INTO state(state_id, state_name) VALUES(108, "West Bengal");

/* Insert into city */
INSERT INTO city(zipcode, city_name, state_id) VALUES(123123, "Jaipur", 101);
INSERT INTO city(zipcode, city_name, state_id) VALUES(320123, "Mumbai", 102);
INSERT INTO city(zipcode, city_name, state_id) VALUES(103123, "Srinagar", 103);
INSERT INTO city(zipcode, city_name, state_id) VALUES(120223, "Shimla", 104);
INSERT INTO city(zipcode, city_name, state_id) VALUES(101013, "Bhopal", 105);
INSERT INTO city(zipcode, city_name, state_id) VALUES(301023, "Banglore", 106);
INSERT INTO city(zipcode, city_name, state_id) VALUES(202020, "Thiruananthapuram", 107);
INSERT INTO city(zipcode, city_name, state_id) VALUES(202023, "Kolkata", 108);
INSERT INTO city(zipcode, city_name, state_id) VALUES(120201, "Jodhpur", 101);
INSERT INTO city(zipcode, city_name, state_id) VALUES(123003, "Udaipur", 101);
INSERT INTO city(zipcode, city_name, state_id) VALUES(122033, "Kota", 101);


/*  write a SQL query for that returns a Resultset containing 
Zip Code, City Names and States ordered by State Name and City Name. */
SELECT zipcode, city_name, state_name
FROM CITY INNER JOIN STATE USING(state_id)
ORDER BY state_name, city_name;