USE library_information_system;

/* Write a select command to display all columns of members table*/
SELECT member_id, name, address_line1, address_line2, category FROM members;
/* OR SELECT * FROM members; */

/* Write a select command to display member_id, name, category columns of members table*/
SELECT member_id, name, category FROM members;

/* Write a select command to display name, member_id, category columns of members table where category is Faculty (F)*/
SELECT name, member_id, category FROM members WHERE category = "F";

/* Write a select command to display various categories of members */
SELECT DISTINCT category FROM members;

/* Write a select command to display member name and their categories in descending order of member name */
SELECT name, category FROM members ORDER BY name DESC;

/* Write a select command to display all the titles, their subjects and publishers */
SELECT title_id, titles.name, subjects.name, publishers.name 
FROM (titles INNER JOIN subjects USING(subject_id)) INNER JOIN publishers
USING(publisher_id);

/* Write a select command to display number of members present in each category. 
The result should include the category and number of members belonging to that category */
SELECT category, COUNT(category) AS "number of members" 
FROM members GROUP BY category;

/* Write a select command to display name of those members who belong to the category
as to which member "Keshav Sharma" belongs*/
SELECT name 
FROM members INNER JOIN (SELECT category FROM members WHERE name = "Keshav Sharma") AS derivedByName
ON members.category = derivedByName.category;

/* Write a select command to display information on all the books issued.
The result should include issue date, accession no, member id, return date.
If the book has not been returned, the column return date should be left blank.*/
SELECT issue_date, accession_no, member_id, return_date AS "Return date"
FROM book_return UNION
SELECT issue_date, accession_no, member_id, "" AS "Return date"
FROM book_issue;

