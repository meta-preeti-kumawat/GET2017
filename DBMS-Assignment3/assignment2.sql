/*Question 1: Write a command to display subjectwise information on number of books purchased.
The information should include subject name, subject_id, number of books purchased.
*/
SELECT subjects.name, subject_id, COUNT(accession_no) AS "Number of Books"
FROM books INNER JOIN titles USING(title_id)
RIGHT JOIN subjects USING(subject_id)
GROUP BY subject_id;

/*Question 2: Write a command to display those rows from the book_issue table 
where a book can be returned after two months.
That is, the difference in due_date and issue_date is greater than two months.
*/
SELECT accession_no, member_id, issue_date, due_date
FROM book_issue 
WHERE TIMESTAMPDIFF(MONTH, `issue_date`, `due_date`) > 2;

/*Question 3: Write a SELECT command to display list of books having price 
greater than the minimum price of books purchased so far.
*/
SELECT accession_no, price
FROM books 
WHERE price > (SELECT MIN(price) from books);