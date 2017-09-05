/*
Create the members table again.
*/

USE library_information_system;

CREATE TABLE IF NOT EXISTS members (
    member_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL,
    address_line1 VARCHAR(45) NOT NULL,
    address_line2 VARCHAR(45),
    category CHAR(1) CHECK(category IN ("M", "F"))
);

/*
Add foreign key constraints again
*/
ALTER TABLE book_issue
ADD CONSTRAINT book_issue_fk_member_id 
FOREIGN KEY(member_id) REFERENCES members(member_id) ON DELETE CASCADE ON UPDATE CASCADE; 

ALTER TABLE book_return
ADD CONSTRAINT book_return_fk_member_id 
FOREIGN KEY(member_id) REFERENCES members(member_id) ON DELETE CASCADE ON UPDATE CASCADE;