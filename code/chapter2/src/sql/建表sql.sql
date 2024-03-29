drop database if exists sampledb;
create database sampledb default character set utf8;
use sampledb;

create table t_user(
user_id int auto_increment primary key,
user_name varchar(30),
credits int,
password varchar(32),
last_visit datetime,
last_ip varchar(23)
)engine=InnoDB;

create table t_login_log(
login_log_id int auto_increment primary key,
user_id int,
ip varchar(23),
login_datetime datetime
)engine=innoDB;

#初始化一条数据alter
insert into t_user (user_name,password) values('admin','123456');
commit;

select * from t_user;