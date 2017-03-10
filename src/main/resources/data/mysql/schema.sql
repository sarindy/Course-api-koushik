CREATE DATABASE  IF NOT EXISTS dynn;
USE dynn;

SET foreign_key_checks = 0;

DROP TABLE IF EXISTS Greeting;

CREATE TABLE Greeting (
  id BIGINT(20) NOT NULL AUTO_INCREMENT,
  text VARCHAR(45) NOT NULL,
  PRIMARY KEY (id));
  
 DROP TABLE IF EXISTS cust_info;
  
 CREATE TABLE cust_info (
  recid BIGINT(20) NOT NULL AUTO_INCREMENT,
  firstname VARCHAR(45) NOT NULL,
  lastname VARCHAR(45) NOT NULL,
  dateofbirth DATE NOT NULL,
  nationality VARCHAR(45) NOT NULL,
  sector int NOT NULL,
  contact VARCHAR(45) NOT NULL,
  email VARCHAR(45),
  address VARCHAR(45) NOT NULL,
  PRIMARY KEY (recid));
  
  DROP TABLE IF EXISTS course;
  
 CREATE TABLE course (
  recid BIGINT(20) NOT NULL AUTO_INCREMENT,
  description VARCHAR(45) NOT NULL,
  deleted int NOT NULL,
  PRIMARY KEY (recid));
  
   DROP TABLE IF EXISTS course_enroll;
  
 CREATE TABLE course_enroll (
  recid BIGINT(20) NOT NULL AUTO_INCREMENT,
  cust_id BIGINT(20) NOT NULL,
  course_id BIGINT(20) NOT NULL,
  PRIMARY KEY (recid),
  INDEX FK_idx (cust_id ASC),
  INDEX COURSEIDFK_idx (course_id ASC),
  CONSTRAINT CUSTIDFK
    FOREIGN KEY (cust_id)
    REFERENCES cust_info (recid)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT COURSEIDFK
    FOREIGN KEY (course_id)
    REFERENCES course (recid)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT);
    SET foreign_key_checks = 1;
  
  
  
  
  
 