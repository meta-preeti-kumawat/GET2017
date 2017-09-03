/*
Insert the sample data back in Publishers table using substitution variables.
*/

SET @id = 0;

INSERT INTO publishers(publisher_id, name)
VALUES(@id := @id + 1, "Genius Publication");

INSERT INTO titles(title_id, name, subject_id, publisher_id)
VALUES(1, "Introduction to Database", 1, @id);

INSERT INTO publishers(publisher_id, name)
VALUES(@id := @id + 1, "Ashirwaad Publication");

INSERT INTO publishers(publisher_id, name)
VALUES(@id := @id + 1, "Tata McGraw Hill");

SELECT publisher_id, name 
FROM publishers;

SELECT title_id, name, subject_id, publisher_id
FROM titles;