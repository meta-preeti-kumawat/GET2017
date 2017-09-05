/*
Insert sample data in LIS tables by using SQL files.
*/
USE library_information_system;

/* members table*/
INSERT INTO members (member_id, name, address_line1, address_line2, category)
VALUES (1, "Priya", "addressA1", "addressA2", "F");
INSERT INTO members (member_id, name, address_line1, address_line2, category)
VALUES (2, "Preeti", "addressB1", "addressB2", "F");
INSERT INTO members (member_id, name, address_line1, address_line2, category)
VALUES (3, "Palak", "addressC1", "addressC2", "O");
INSERT INTO members (member_id, name, address_line1, address_line2, category)
VALUES (4, "Prachi", "addressD1", "addressD2", "S");
INSERT INTO members (member_id, name, address_line1, address_line2, category)
VALUES (5, "Pallav", "addressD1", "addressE2", "S");
INSERT INTO members (member_id, name, address_line1, address_line2, category)
VALUES (6, "Keshav Sharma", "addressE1", "Jaipur", "F");

/* subjects table*/
INSERT INTO subjects (subject_id, name)
VALUES (1, "Database");
INSERT INTO subjects (subject_id, name)
VALUES (2, "HTML");
INSERT INTO subjects (subject_id, name)
VALUES (3, "CSS");
INSERT INTO subjects (subject_id, name)
VALUES (4, "JAVA");
INSERT INTO subjects (subject_id, name)
VALUES (5, "C");

/* publisher table*/
INSERT INTO publishers (publisher_id, name)
VALUES (1, "Genius Publication");
INSERT INTO publishers (publisher_id, name)
VALUES (2, "Ashirwaad Publication");
INSERT INTO publishers (publisher_id, name)
VALUES (3, "NK Publication");
INSERT INTO publishers (publisher_id, name)
VALUES (4, "CBC Publication");

/* authors table*/
INSERT INTO authors (author_id, name)
VALUES (1, "Galvin");
INSERT INTO authors (author_id, name)
VALUES (2, "Priya");
INSERT INTO authors (author_id, name)
VALUES (3, "Preeti");
INSERT INTO authors (author_id, name)
VALUES (4, "Palak");
INSERT INTO authors (author_id, name)
VALUES (5, "Prachi");

/* titles table*/
INSERT INTO titles (title_id, name, subject_id, publisher_id)
VALUES (1, "Introduction to Database", 1, 1);
INSERT INTO titles (title_id, name, subject_id, publisher_id)
VALUES (2, "Introduction to HTML", 2, 1);
INSERT INTO titles (title_id, name, subject_id, publisher_id)
VALUES (3, "Introduction to CSS", 3, 2);
INSERT INTO titles (title_id, name, subject_id, publisher_id)
VALUES (4, "Introduction to JAVA", 4, 3);
INSERT INTO titles (title_id, name, subject_id, publisher_id)
VALUES (5, "Introduction to C", 4, 3);

/* title_author table*/
INSERT INTO title_author (title_id, author_id) 
VALUES (1, 3);
INSERT INTO title_author (title_id, author_id) 
VALUES (2, 2);
INSERT INTO title_author (title_id, author_id) 
VALUES (3, 4);
INSERT INTO title_author (title_id, author_id) 
VALUES (4, 5);
INSERT INTO title_author (title_id, author_id) 
VALUES (5, 3);

/* books table*/
INSERT INTO books (accession_no, title_id, purchase_date, price, status) 
VALUES (1, 1, "2017-05-25", 200, "available");
INSERT INTO books (accession_no, title_id, purchase_date, price, status) 
VALUES (2, 1, "2017-06-05", 500, "available");
INSERT INTO books (accession_no, title_id, purchase_date, price, status) 
VALUES (3, 4, "2015-08-15", 100.75, "available");
INSERT INTO books (accession_no, title_id, purchase_date, price, status) 
VALUES (4, 3, "2016-08-13", 100.75, "lost");
INSERT INTO books (accession_no, title_id, purchase_date, price, status) 
VALUES (5, 2, "2012-12-25", 100.75, "available");

/* book_issue table*/
INSERT INTO book_issue (accession_no, member_id) 
VALUES (2, 2);
INSERT INTO book_issue (accession_no, member_id) 
VALUES (3, 1);
INSERT INTO book_issue (accession_no, member_id) 
VALUES (1, 2);
INSERT INTO book_issue (accession_no, member_id) 
VALUES (5, 1);

INSERT INTO book_return (accession_no, member_id) 
VALUES (3, 1);
INSERT INTO book_return (accession_no, member_id) 
VALUES (2, 2);