USE library_information_system;

/* Question 1: Write a SELECT command to display name of those members
who belong to the category as to which member
“Jon Snow” belongs.
Note: Solve the problem using subquery.
*/
SELECT m1.name
FROM members AS m1
WHERE m1.category = (
    SELECT m2.category 
    FROM members AS m2 
    WHERE m2.name = "JON SNOW"
);


/* Question 2: Write a SELECT command to display information on the books
that have not been returned till date. The information should
include book issue date, title, member name and due date.
Note: Use Correlated Subquery.
*/
SELECT issue.accession_no, issue_date, t.name AS "Title Name", m.member_id, m.name AS "Member Name", due_date
FROM book_issue issue
INNER JOIN members m USING(member_id)
INNER JOIN books USING(accession_no)
INNER JOIN titles t USING(title_id)
WHERE NOT EXISTS (
   SELECT * FROM book_return r
   WHERE issue.issue_date = r.issue_date 
   AND issue.accession_no = r.accession_no
); 


/* Question 3:  Write a SELECT command to display information on the books
that have been returned after their due dates. The information
should include book issue date, title, member name and due
date.
Note: Use Correlated Subquery.
*/
SELECT issue.issue_date, t.name AS "Title Name", m.name AS "Member Name", issue.due_date
FROM book_issue issue 
INNER JOIN members m USING(member_id)
INNER JOIN books USING(accession_no)
INNER JOIN titles t USING(title_id)
WHERE EXISTS (
    SELECT * FROM book_return r
    WHERE r.accession_no = issue.accession_no
    AND r.issue_date = issue.issue_date 
    AND r.return_date > issue.due_date
);


/* Question 4:   Write a SELECT command to display information of those books
whose price is equal to the most expensive book purchase so far.
*/
SELECT accession_no, title_id, purchase_date, price, status
FROM books
WHERE price = (
    SELECT MAX(price) 
    FROM books
);


/* Question 5: Write a SELECT command to display the second maximum price
of a book.
*/
SELECT accession_no, title_id, purchase_date, price, status
FROM books b1
WHERE 1 = (
    SELECT COUNT(DISTINCT(price))
    FROM books b2
    WHERE b1.price < b2.price
);