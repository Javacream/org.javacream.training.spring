drop table AUDIT if exists
drop table ISBNCOUNTER if exists
create table AUDIT (auditmessage varchar(2048))
create table ISBNCOUNTER (counter integer)