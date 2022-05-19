create table messages (message varchar(1024))
create table store (category varchar(20), item varchar(20), stock integer, primary key (category, item))