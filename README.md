First of all create 6 tables in mysql with a names following ,
User Table,
Restaurant Table,
Menu Table,
Order Table ,
OrderItems Table,
OrderHistory Table,

like one example for user is given below

CREATE TABLE foodapp.user ( userId INT NOT NULL AUTO_INCREMENT, userName VARCHAR(45) NULL, email VARCHAR(45) NOT NULL, phoneNumber VARCHAR(45) NULL, password VARCHAR(45) NOT NULL, address VARCHAR(45) NULL, createdDate DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP, lastLogin DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP, PRIMARY KEY (userId));
