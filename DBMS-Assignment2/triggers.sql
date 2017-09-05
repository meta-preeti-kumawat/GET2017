/*
Alter definitions of following LIS tables to provide the default constraints:

+---------------+-------------------+-------------------------------+
|    Table      |        Column     |    Default value              |
+---------------+-------------------+-------------------------------+
|    book_issue |      issue_date   |    Current date               |
+---------------+-------------------+-------------------------------+
|    book_issue |        due_date   |    Current date + 15 days     |
+---------------+-------------------+-------------------------------+

*/
ALTER TABLE book_issue 
MODIFY COLUMN issue_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP;


/*
due_date is set using trigger
*/
DELIMITER $$
CREATE TRIGGER due_date_15days
BEFORE INSERT ON `book_issue` FOR EACH ROW
BEGIN
    IF ( (SELECT status FROM books WHERE accession_no = NEW.accession_no) = "available" ) THEN  
        SET NEW.due_date = NOW() + INTERVAL 15 DAY;
        
        UPDATE books 
        SET status = "issued" 
        WHERE accession_no = NEW.accession_no;
    ELSE
        DELETE FROM book_issue 
        WHERE NEW.accession_no = accession_no 
        AND NEW.issue_date = issue_date 
        AND NEW.member_id = member_id;
    END IF;
END;
$$
DELIMITER ;

DELIMITER $$
CREATE TRIGGER change_book_status
BEFORE INSERT ON `book_return` FOR EACH ROW
BEGIN
    
    IF((SELECT status FROM books WHERE accession_no = NEW.accession_no) = "issued") THEN
        SET NEW.issue_date = (
            SELECT issue_date 
            FROM book_issue 
            WHERE accession_no = NEW.accession_no 
            AND NEW.member_id = member_id
        );
    
        UPDATE books 
        SET status = "available" 
        WHERE accession_no = NEW.accession_no;
    
        DELETE FROM book_issue 
        WHERE NEW.accession_no = accession_no 
        AND NEW.issue_date = issue_date 
        AND NEW.member_id = member_id;
    ELSE
        DELETE FROM book_return
        WHERE NEW.accession_no = accession_no 
        AND NEW.issue_date = issue_date 
        AND NEW.member_id = member_id;
        
    END IF;
END;
$$
DELIMITER ;



ALTER TABLE book_return 
MODIFY COLUMN return_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP;
