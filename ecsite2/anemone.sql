set names utf8;
set foreign_key_checks = 0;
drop database if exists anemone;

create database if not exists anemone;
use anemone;


drop table if exists user_info;
create table user_info(
	id int not null primary key auto_increment,
	user_id varchar(16) unique not null,
	password varchar(16) not null,
	family_name varchar(32) not null,
	first_name varchar(32) not null,
	family_name_kana varchar(32) not null,
	first_name_kana varchar(32) not null,
	sex tinyint default 0 not null,
	email varchar(32) not null,
	status tinyint default 0 not null,
	logined tinyint default 0 not null,
	regist_date datetime not null,
	update_date datetime
);


drop table if exists product_info;
create table product_info(
	id int not null primary key auto_increment,
	product_id int unique,
	product_name varchar(100) unique,
	product_name_kana varchar(100) unique,
	product_description varchar(255),
	category_id int,
	price int,
	image_file_path varchar(100),
	image_file_name varchar(50),
	release_date datetime,
	release_company varchar(50),
	status tinyint default 1,
	regist_date datetime,
	update_date datetime
);

insert into product_info values(
	1, 1, "本１", "ほん１", "本１の詳細設定", 0, 2100, "./images", "sample.png",
	now(), "発売会社", 1, now(), now()
);

insert into product_info(product_id, product_name, product_name_kana,
product_description, category_id, price, image_file_path, image_file_name,
release_date, release_company, regist_date)
values(0, CONCAT("本", "a"), "product_name_kana", "product_description",
0, 0, "image_file_path", "image_file_name", "2000/1/1", "release_company",
"2000/1/1");


drop table if exists cart_info;
create table cart_info(
	id int not null primary key auto_increment,
	user_id varchar(16),
	temp_user_id varchar(16),
	product_id int,
	product_count int,
	price int,
	regist_date datetime,
	update_date datetime
);


drop table if exists purchase_history_info;
create table purchase_history_info(
	id int not null primary key auto_increment,
	user_id varchar(16),
	product_id int,
	product_count int,
	price int,
	destination_id int,
	regist_date datetime,
	update_date datetime
);



drop table if exists destination_info;
create table destination_info(
	id int not null primary key auto_increment,
	user_id varchar(16),
	family_name varchar(32),
	first_name varchar(32),
	family_name_kana varchar(32),
	first_name_kana varchar(32),
	email varchar(32),
	tel_number varchar(50),
	regist_date datetime,
	update_date datetime
);


drop table if exists m_category;
create table m_category(
	id int not null primary key auto_increment,
	category_id int unique,
	category_name varchar(20) unique,
	category_description varchar(100),
	insert_date datetime,
	update_date datetime
);

insert into m_category(category_id, category_name, category_description,
insert_date) values(0, "category_name", "category_description", "2000/1/1");



insert into user_info(user_id, password, family_name, first_name,
family_name_kana, first_name_kana, sex, email, status, logined, regist_date)
values("guest1", "guest1", "family_name", "first_name", "family_name_kana", "first_name_kana",
0, "email", 0, 0, "2000/1/1");

insert into user_info(user_id, password, family_name, first_name,
family_name_kana, first_name_kana, sex, email, status, logined, regist_date)
values("guest2", "guest2", "family_name", "first_name", "family_name_kana", "first_name_kana",
0, "email", 0, 0, "2000/1/1");

insert into user_info(user_id, password, family_name, first_name,
family_name_kana, first_name_kana, sex, email, status, logined, regist_date)
values("guest3", "guest3", "family_name", "first_name", "family_name_kana", "first_name_kana",
0, "email", 0, 0, "2000/1/1");


insert into user_info(user_id, password, family_name, first_name,
family_name_kana, first_name_kana, sex, email, status, logined, regist_date)
values("guest4", "guest4", "family_name", "first_name", "family_name_kana", "first_name_kana",
0, "email", 0, 0, "2000/1/1");

insert into user_info(user_id, password, family_name, first_name,
family_name_kana, first_name_kana, sex, email, status, logined, regist_date)
values("guest5", "guest5", "family_name", "first_name", "family_name_kana", "first_name_kana",
0, "email", 0, 0, "2000/1/1");

insert into user_info(user_id, password, family_name, first_name,
family_name_kana, first_name_kana, sex, email, status, logined, regist_date)
values("guest6", "guest6", "family_name", "first_name", "family_name_kana", "first_name_kana",
0, "email", 0, 0, "2000/1/1");

insert into user_info(user_id, password, family_name, first_name,
family_name_kana, first_name_kana, sex, email, status, logined, regist_date)
values("guest7", "guest", "family_name", "first_name", "family_name_kana", "first_name_kana",
0, "email", 0, 0, "2000/1/1");

insert into user_info(user_id, password, family_name, first_name,
family_name_kana, first_name_kana, sex, email, status, logined, regist_date)
values("guest8", "guest8", "family_name", "first_name", "family_name_kana", "first_name_kana",
0, "email", 0, 0, "2000/1/1");

insert into user_info(user_id, password, family_name, first_name,
family_name_kana, first_name_kana, sex, email, status, logined, regist_date)
values("guest9", "guest9", "family_name", "first_name", "family_name_kana", "first_name_kana",
0, "email", 0, 0, "2000/1/1");

insert into user_info(user_id, password, family_name, first_name,
family_name_kana, first_name_kana, sex, email, status, logined, regist_date)
values("guest10", "guest10", "family_name", "first_name", "family_name_kana", "first_name_kana",
0, "email", 0, 0, "2000/1/1");

insert into user_info(user_id, password, family_name, first_name,
family_name_kana, first_name_kana, sex, email, status, logined, regist_date)
values("guest11", "guest11", "family_name", "first_name", "family_name_kana", "first_name_kana",
0, "email", 0, 0, "2000/1/1");

insert into user_info(user_id, password, family_name, first_name,
family_name_kana, first_name_kana, sex, email, status, logined, regist_date)
values("guest12", "guest12", "family_name", "first_name", "family_name_kana", "first_name_kana",
0, "email", 0, 0, "2000/1/1");


for i in 1..5 loop
	dbms_output.put_line('iの中身は' || i);
end loop;


