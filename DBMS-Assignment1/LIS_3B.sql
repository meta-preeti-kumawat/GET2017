/*
Change value of addressLine2 column of Members table with “Jaipur”.
*/
UPDATE `members` 
SET address_line2 = "Jaipur";

SELECT member_id, name, address_line1, address_line2, category 
FROM members