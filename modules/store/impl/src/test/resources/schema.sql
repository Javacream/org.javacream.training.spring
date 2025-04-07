DROP TABLE STORE IF EXISTS
CREATE TABLE STORE(category varchar(48), item varchar(48), stock integer, primary key (category, item))