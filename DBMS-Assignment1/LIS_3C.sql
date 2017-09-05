/*
Change value of addressLine1 column of Members table with value “EPIP, Sitapura” 
for the members belonging to category “F”.
*/
UPDATE `members` 
SET address_line1 = "EPIP, Sitapura"
WHERE category = "F";
