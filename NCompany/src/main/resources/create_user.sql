CREATE USER 'ncompanyuser'@'localhost' IDENTIFIED BY 'nksinc';

GRANT ALL PRIVILEGES ON n_company.* TO 'ncompanyuser'@'localhost' WITH GRANT OPTION;

SHOW GRANTS FOR 'ncompanyuser'@'localhost';
