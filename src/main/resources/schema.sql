CREATE TABLE ISBNS (isbn integer)
CREATE TABLE STORE (category varchar(20), item varchar(20), stock integer, primary key(category, item))