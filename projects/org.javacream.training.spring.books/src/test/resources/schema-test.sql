drop table TEST_MESSAGES if exists
drop table STORE if exists
create table TEST_MESSAGES (message varchar(256)) 
create table STORE (category varchar(256), item varchar(256), stock int, primary key (category, item))