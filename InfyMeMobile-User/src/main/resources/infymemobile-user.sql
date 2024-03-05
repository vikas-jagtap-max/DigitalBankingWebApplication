create database infymemobile_db;

use infymemobile_db;

create table user(
mobile_number BIGINT primary key,
user_id varchar(20) unique,
account_holder_name varchar(50) Not Null,
gender varchar(20) Not Null,
date_of_birth date Not Null,
password varchar(50) Not null,
email varchar(50) Not null,
communication_address varchar(100) Not null,
PAN varchar(20) Not null);

desc user;

insert into user values(7558444051, "U123", "Akash Phule", "Male", "1999-11-10", "Ganesh@123", "aphule@gmail.com", "Jategaon Phulambri", "BBUPC124N");
insert into user values(9561995449, "U124", "Vikas Jagtap", "Male", "1999-10-07", "Vikas@123", "vjagtap@gmail.com", "Shirdi Ahmednagar", "BBUPC125M");
insert into user values(7350046194, "U125", "Vaibahv Singh", "Male", "1996-01-10", "Vaibhav@123", "vsingh@gmail.com", "Ravet Pune", "BBUPC126O");

select * from user;


