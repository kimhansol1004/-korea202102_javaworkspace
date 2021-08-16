drop table shoppingapp.product;

create table shoppingapp.product(
	product_id int primary key auto_increment
	, subcategory_id int
	, product_name varchar(30)
	, price int default 0 
	, brand varchar(30)
	, detail text
	, filename varchar(40)
) default character set utf8;

select * from shoppingapp.product where product_name like '%점퍼%' 


create  table  notice(
   notice_id int primary key auto_increment
  , title varchar(100)
  , writer varchar(20)
  , content text 
  , regdate  timestamp  default now()
  , hit  int default 0 
) default character set utf8;
