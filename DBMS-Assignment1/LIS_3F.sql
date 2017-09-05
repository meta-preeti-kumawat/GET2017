/*
Delete those rows of Titles table belonging to Publisher with publisher_id = 1
*/
DELETE FROM titles where publisher_id = 1;

SELECT title_id, name, subject_id, publisher_id
FROM titles;