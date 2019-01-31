set names utf8;
set foreign_key_checks = 0;

drop database if exists exam;
create database if not exists exam;
use exam;

drop table if exists users;
create table users(
	id_number int not null primary key auto_increment,
	user_name varchar(30),
	password varchar(30),
	admin_flg varchar(4),
	birthDay varchar(255)
);


drop table if exists items;
create table items(
	id_number int not null primary key auto_increment,
	buyItemName varchar(255),
	buyItemPrice int,
	Category int,
	imagePath varchar(255),
	discription varchar(255)
);


drop table if exists user_buy_items;
create table user_buy_items(
	number int not null primary key auto_increment,
	buyUserIdNumber int,
	buyItemName varchar(255),
	buyCount int,
	total_price int,
	buyDate varchar(255)
);


drop table if exists Cart;
create table Cart(
	number int not null primary key auto_increment,
	addUserIdNumber int,
	ItemName varchar(255),
	ItemPrice int,
	Count int,
	total_price int,
	addDate varchar(255)
);


drop table if exists Address;
create table Address( 
	number int not null primary key auto_increment,
	UserIdNumber int,
	Country varchar(255),
	State varchar(255),
	Contact varchar(255)
);


insert into users(user_name, password, admin_flg) values("taro", "123","root");


insert into items(buyItemName, buyItemPrice, Category, imagePath, discription) values("良いPC", "300000", 1, "photos/mac.png", "超高性能ハイスペックパソコンです");
insert into items(buyItemName, buyItemPrice, Category, imagePath, discription) values("悪いPC", "30", 1, "photos/ポンコツPC.png", "低性能なポンコツパソコンです");
insert into items(buyItemName, buyItemPrice, Category, imagePath, discription) values("良い机", "1000000", 2, "photos/newDesk.jpg", "とても良い机で、学習などに使えます");
insert into items(buyItemName, buyItemPrice, Category, imagePath, discription) values("悪い机", "100", 2, "photos/brokenDesk.jpg", "中古の机です。ガタガタしています。");
insert into items(buyItemName, buyItemPrice, Category, imagePath, discription) values("良い椅子", "50000", 3, "photos/goodChair.png", "新品のイスです。フランス製");
insert into items(buyItemName, buyItemPrice, Category, imagePath, discription) values("悪い椅子", "50", 3, "photos/brokenChair.png", "使い古したイスです。耐荷重量は2kgまでです。");

insert into Cart(addUserIdNumber, ItemName, ItemPrice, Count) values(0, "apple", 100, 2);
insert into Address(UserIdNumber, Country, State, Contact) values(0, "Country", "State", "Contact");

