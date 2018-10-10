drop table STORE if exists
drop table AUDIT if exists
create table STORE (category varchar(256), item varchar(256), stock integer, primary key (category, item))
create table AUDIT (auditmessage varchar(2048))