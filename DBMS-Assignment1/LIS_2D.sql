/*
Write a command to remove Members table of the LIS database.
*/

/*
First we need to remove foreign key references from book_issue and book_return tables
*/
ALTER TABLE book_issue
DROP FOREIGN KEY book_issue_fk_member_id; 

ALTER TABLE book_return
DROP FOREIGN KEY book_return_fk_member_id;

DROP table library_information_system.members;
