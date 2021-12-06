drop table STORE if exists;
create table STORE (category varchar(20), item varchar(30), stock integer, primary key (category, item));