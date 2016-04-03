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

CREATE TABLE `n_company`.`department` (
  `deptId` INT NOT NULL AUTO_INCREMENT,
  `deptName` VARCHAR(45) NOT NULL,
  `location` VARCHAR(45) NULL,
  PRIMARY KEY (`deptId`));
  
INSERT INTO `n_company`.`department` (`deptName`, `location`) VALUES ('account', 'dallas');
INSERT INTO `n_company`.`department` (`deptName`, `location`) VALUES ('sales', 'newyork');
INSERT INTO `n_company`.`department` (`deptName`, `location`) VALUES ('marketing', 'newyork');


CREATE TABLE `n_company`.`project` (
  `projId` INT NOT NULL AUTO_INCREMENT,
  `projName` VARCHAR(45) NOT NULL,
  `startDate` DATE NULL,
  `endDate` DATE NULL,
  `deptId` INT NOT NULL,
  PRIMARY KEY (`projId`));

  INSERT INTO `n_company`.`project` (`projName`, `startDate`, `deptId`) VALUES ('phpproj', '2016-2-2', '1');
INSERT INTO `n_company`.`project` (`projName`, `startDate`, `deptId`) VALUES ('javaproject', '2015-10-10', '2');
INSERT INTO `n_company`.`project` (`projName`, `startDate`, `deptId`) VALUES ('dotnetproject', '2015-12-12', '1');



