CREATE TABLE `mediamanager`.`userdetails` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `USERNAME` VARCHAR(50) NULL,
  `PASSWORD` VARCHAR(50) NULL,
  `AUTHLEVEL` INT NOT NULL,
  PRIMARY KEY (`ID`));