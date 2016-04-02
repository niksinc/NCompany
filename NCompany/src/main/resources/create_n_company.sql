delimiter ;
DROP SCHEMA IF EXISTS `n_company`; 
CREATE SCHEMA `n_company` ;
use `n_company`;
delimiter $$


CREATE TABLE `n_company`.`employee` (
  `empId` INT NOT NULL AUTO_INCREMENT,
  `fName` VARCHAR(45) NOT NULL,
  `lName` VARCHAR(45) NULL,
  `email` VARCHAR(45) NOT NULL,
  `phoneNumber` CHAR(10) NULL,
  PRIMARY KEY (`empId`));

INSERT INTO `n_company`.`employee` (`fName`, `lName`, `email`, `phoneNumber`) VALUES ('nikhil', 'surti', 'n@gmail.com', '9558885756');
INSERT INTO `n_company`.`employee` (`fName`, `lName`, `email`, `phoneNumber`) VALUES ('romil', 'surti', 'r@gmail.com', '7892586541');
INSERT INTO `n_company`.`employee` (`fName`, `lName`, `email`, `phoneNumber`) VALUES ('divya', 'surti', 'd@gmail.com', '6547419512');

