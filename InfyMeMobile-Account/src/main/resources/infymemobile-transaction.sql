use infymemobile_db;

drop table if exists transaction;

create table transaction( 
transaction_id Integer auto_increment primary key, 
mode_of_transaction varchar(50) not null, 
paid_to long not null,
receiver_account_number long not null,
amount double not null, 
transaction_date_time datetime not null, 
remarks varchar(50) not null,
paid_from long not null,
sender_account_number long not null
);

desc transaction;

insert into transaction values (123456789, "Fund Transfer", 7022713755,55810643722, 12890, current_timestamp(), "Payment for Grociries", 7558444051, 55810643789);
insert into transaction values (123456790, "Fund Transfer", 7022713755, 55810643722, 2000, current_timestamp(), "Payment for Maintenance", 9561995449, 55810643710);
insert into transaction values (123456777, "Fund Transfer", 9876987431, 91510123876, 1000, current_timestamp(), "Payment for Light Bill", 9561995449, 55810643710);

select * from transaction;