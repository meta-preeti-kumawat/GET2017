/* Question 1: Create a View which can be used to display member name and
all issue details of the member using a simple SELECT command.
*/
CREATE OR REPLACE VIEW member_issue_details
AS
SELECT name, accession_no, issue_date, due_date
FROM members  
INNER JOIN book_issue USING(member_id);

SELECT * FROM member_issue_details;


/* Question 2: Create a View which contains three columns, member name,
member id and full description of category, i.e., Faculty, Students
and Others instead of F,S and O.
*/
CREATE OR REPLACE VIEW member_details
AS
SELECT name, member_id, 
CASE category
    WHEN ("F") THEN "Faculty"
    WHEN ("O") THEN "Others"
    WHEN ("S") THEN "Student"
END AS "Category"
FROM members  
INNER JOIN book_issue USING(member_id);

SELECT * FROM member_details;


/* Question 3: Create a View which contains the information – subject name,
title, member name, category, issue date, due date and return
date. If the books have not been returned, NULL should be
displayed instead of return date.
*/
CREATE OR REPLACE VIEW issued_books
AS
SELECT s.name AS "Subject", t.name AS "Title", m.name AS "Member",
CASE category
    WHEN ("F") THEN "Faculty"
    WHEN ("O") THEN "Others"
    WHEN ("S") THEN "Student"
END AS "Category",
issue_date, due_date, IFNULL(return_date, "NULL") AS "Return Date"
FROM book_issue bi
INNER JOIN books USING(accession_no)
INNER JOIN titles t USING(title_id)
INNER JOIN subjects s USING(subject_id)
INNER JOIN members m USING (member_id)
LEFT JOIN book_return USING(accession_no, member_id, issue_date);

SELECT * FROM issued_books;
