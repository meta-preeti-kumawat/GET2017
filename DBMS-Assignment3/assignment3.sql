/*Question 1: Write a SELECT command to display total Number of students, 
total number of faculty and total number of others in library information system
in a single row.
*/
SELECT GROUP_CONCAT( CONCAT_WS(' : ', m.category, count) SEPARATOR '  ;  ') AS "Category Count"
FROM (
SELECT category, COUNT(member_id) AS count
FROM members
GROUP BY category) AS m;

/*Question 2: Display the information of those titles that have been issued more than 2 times.
*/
SELECT title_id, name
FROM titles INNER JOIN books USING(title_id)
INNER JOIN (SELECT accession_no FROM book_return 
UNION ALL SELECT accession_no FROM book_issue) AS derived USING(accession_no)
GROUP BY title_id
HAVING COUNT(accession_no) > 2;

/*Question 3: Write a command to display information on books
issued to members of category other than "F" (Faculty)
*/
SELECT DISTINCT(accession_no), title_id, purchase_date, price, status
FROM books
INNER JOIN (SELECT accession_no, member_id FROM book_return 
UNION ALL SELECT accession_no, member_id FROM book_issue) AS derived USING(accession_no)
INNER JOIN members USING (member_id)
WHERE category NOT IN ("F");

/*Question 4: Write a command to display information on those authors
for which atleast one book has been purchased
*/
SELECT DISTINCT(author_id), authors.name
FROM authors 
INNER JOIN title_author USING(author_id)
INNER JOIN titles USING (title_id)
INNER JOIN books USING (title_id);