drop table if exists product;
drop table if exists category;

create table category(
	category_id int not null auto_increment,
	name varchar(200) not null,
	primary key(category_id)
);


create table product(
	product_id int not null AUTO_INCREMENT,
	name varchar(200) not null,
	price double not null,
	list_price double not null,
	price_valid_until date default null,
	category_id int not null,
	creation_date datetime not null,
	update_date datetime not null,
	primary key(product_id),
	foreign key(category_id) references category(category_id)
);

insert into category values (1, 'Tecnología');

select * from category;

select * from product;

