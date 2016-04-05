/* creating the schema if it is exist then it will drop the schema and
 * create the new schema */
delimiter ;
DROP SCHEMA IF EXISTS `n_company`; 
CREATE SCHEMA `n_company` ;
use `n_company`;
delimiter $$

/* this table is useful for the employee data when the new employee hired 
 * then the data should be enter in this employee table empId is Promary Key 
 * and it is auto generated */

CREATE TABLE `n_company`.`employee` (
  `empId` INT NOT NULL AUTO_INCREMENT,
  `fName` VARCHAR(45) NOT NULL,
  `lName` VARCHAR(45) NULL,
  `email` VARCHAR(45) NOT NULL,
  `phoneNumber` CHAR(10) NULL,
  PRIMARY KEY (`empId`));
/* sample Employee data insert */
INSERT INTO `n_company`.`employee` (`fName`, `lName`, `email`, `phoneNumber`) VALUES ('nikhil', 'surti', 'n@gmail.com', '9558885756');
INSERT INTO `n_company`.`employee` (`fName`, `lName`, `email`, `phoneNumber`) VALUES ('romil', 'surti', 'r@gmail.com', '7892586541');
INSERT INTO `n_company`.`employee` (`fName`, `lName`, `email`, `phoneNumber`) VALUES ('divya', 'surti', 'd@gmail.com', '6547419512');


/* this is deprtment table it is usefull for storing the department detail
 * when new department open in the company the entry will goes into this 
 * table, deptId is Primary key for this table and it is auto generated
 * */
CREATE TABLE `n_company`.`department` (
  `deptId` INT NOT NULL AUTO_INCREMENT,
  `deptName` VARCHAR(45) NOT NULL,
  `location` VARCHAR(45) NULL,
  PRIMARY KEY (`deptId`));
  
  /* sample data for the department table */
INSERT INTO `n_company`.`department` (`deptName`, `location`) VALUES ('account', 'dallas');
INSERT INTO `n_company`.`department` (`deptName`, `location`) VALUES ('sales', 'newyork');
INSERT INTO `n_company`.`department` (`deptName`, `location`) VALUES ('marketing', 'newyork');


/* Project table is useful for storing the project detail it is having 
 * startdate and enddate which is project start date and enddate
 * projId is Primary Key and it is auto generated and deptId is the foreign key,
 * which is referencing to the department table */

CREATE TABLE `n_company`.`project` (
  `projId` INT NOT NULL AUTO_INCREMENT,
  `projName` VARCHAR(45) NOT NULL,
  `startDate` DATE NULL,
  `endDate` DATE NULL,
  `deptId` INT NOT NULL,
  PRIMARY KEY (`projId`));

ALTER TABLE `n_company`.`project` 
CHANGE COLUMN `startDate` `startDate` VARCHAR(45) NULL ,
CHANGE COLUMN `endDate` `endDate` VARCHAR(45) NULL DEFAULT NULL ;

 /* sample data for the deparment table */
 INSERT INTO `n_company`.`project` (`projName`, `startDate`, `deptId`) VALUES ('phpproj', '2016-2-2', '1');
INSERT INTO `n_company`.`project` (`projName`, `startDate`, `deptId`) VALUES ('javaproject', '2015-10-10', '2');
INSERT INTO `n_company`.`project` (`projName`, `startDate`, `deptId`) VALUES ('dotnetproject', '2015-12-12', '1');



