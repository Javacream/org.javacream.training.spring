create table messages(message varchar(256))
create table Store (category varchar(50), item varchar(50), stock int, primary key (category, item))
create table keys (key int)
create table Book (isbn varchar(255), title varchar(255), price double, primary key (isbn))
