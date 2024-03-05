use infymemobile_db;

drop table if exists bank_account;

create table bank_account (
account_number bigint primary key auto_increment,
bank_name varchar(50) Not null,
balance double Not null,
account_type varchar(50) not null,
ifsc_code varchar(50) Not null,
opening_date date Not null,
mobile_number bigint Not null,
Foreign Key (mobile_number) references user (mobile_number)
);

desc bank_account;

insert into bank_account values (55810643789, "ICICI", 120000.00, "Savings", "ICIC1234321", "2022-07-30", 7558444051);
insert into bank_account values (55810643710,"ICICI", 500000.00, "Salary", "ICIC1234321", "2022-08-30", 9561995449);
insert into bank_account values (91510123876, "AXIS", 20000.00, "Current", "AXIS1234321", "2021-05-15", 7350046194);

Select * from bank_account;