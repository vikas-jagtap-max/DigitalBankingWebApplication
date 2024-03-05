use infymemobile_db;

drop table if exists digital_bank_account;

create table digital_bank_account ( 
digital_banking_id varchar(50) primary key, 
mobile_number bigint NOT NULL,
Foreign key (mobile_number) references user (mobile_number), 
account_number bigint NOT NULL,
Foreign key (account_number) references bank_account (account_number), 
account_type varchar(50) NOT NULL
);

desc digital_bank_account;

insert into digital_bank_account values ("w_1001",7558444051, 55810643789,"Savings"); 
insert into digital_bank_account values ("w_1002", 9561995449,55810643710, "Current");
insert into digital_bank_account values ("w_1003",7350046194, 91510123876,"Salary");

Select * from digital_bank_account;