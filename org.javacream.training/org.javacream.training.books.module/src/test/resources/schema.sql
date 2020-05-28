drop table STORE if exists
drop table BOOKSORDER if exists
create table STORE (category varchar(256), item varchar(256), stock integer, primary key (category, item))
create table BOOKSORDER (isbn varchar(256), amount integer)
