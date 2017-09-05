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
   SET NEW.due_date = NOW() + INTERVAL 15 DAY;
END;
$$
DELIMITER ;