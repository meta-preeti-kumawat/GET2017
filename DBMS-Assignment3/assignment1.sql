USE library_information_system;

/*Question 1: Write a command to display information on books issued for more than two months.
The information should include member name, member_id, title name, accession_no, 
issue_date, due_date and issued for how many months 
and be sorted on member name, and within member name on title name*/
SELECT m.name AS "Member Name", m.member_id, t.name AS "Title", b.accession_no, issue_date, due_date,
TIMESTAMPDIFF(MONTH, `issue_date`,CURRENT_TIMESTAMP()) AS "Duration In Months"
FROM ((book_issue INNER JOIN members AS m USING(member_id))
INNER JOIN books AS b USING(accession_no))
INNER JOIN titles AS t USING(title_id)
WHERE TIMESTAMPDIFF(MONTH, `issue_date`,CURRENT_TIMESTAMP()) >= 2
ORDER BY m.name, t.name;

/*Alternate Query for question 1*/

SELECT *
FROM
(
SELECT m.name AS "Member Name", m.member_id, t.name AS "Title", b.accession_no, issue_date, due_date,
TIMESTAMPDIFF(MONTH, `issue_date`,CURRENT_TIMESTAMP()) AS "Duration In Months"
FROM ((book_issue INNER JOIN members AS m USING(member_id))
INNER JOIN books AS b USING(accession_no))
INNER JOIN titles AS t USING(title_id)
ORDER BY m.name, t.name
) AS subQuery
WHERE `Duration In Months` >= 2;

/*Question 2: Write a command to display those rows
from members table having maximun length for member name.
Information should contain member name and length of member name*/
SELECT name, LENGTH(name) AS length
FROM members
WHERE LENGTH(name) = (SELECT MAX(LENGTH(name)) FROM members);

/*Question 3: Write a command to display count of number of books issued so far*/
SELECT COUNT(accession_no) AS "Number of books issued"
FROM (SELECT DISTINCT(accession_no)
FROM book_return UNION
SELECT DISTINCT(accession_no)
FROM book_issue) AS result;