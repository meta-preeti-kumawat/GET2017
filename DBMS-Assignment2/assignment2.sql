USE library_information_system;
/* Assignment 2: Write a select command to display information on all the books issued.
The result should include issue date, accession no, member id, return date.
If the book has not been returned, the column return date should be left blank.*/
SELECT * 
FROM (SELECT issue_date, accession_no, member_id, return_date AS "Return date"
FROM book_return 
UNION SELECT issue_date, accession_no, member_id, "" AS "Return date"
FROM book_issue) AS data 
INNER JOIN (SELECT member_id, name 
FROM members) AS member USING(member_id) 
ORDER BY data.issue_date, name;