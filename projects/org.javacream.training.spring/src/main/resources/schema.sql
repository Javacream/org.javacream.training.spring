create table store (category varchar(255), item varchar(255), stock integer, primary key (category, item))
create table book (isbn varchar(255), title varchar(255), price double, primary key (isbn))