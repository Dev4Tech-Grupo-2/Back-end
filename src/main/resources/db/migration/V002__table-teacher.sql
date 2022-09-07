create table if not exists teacher(
	id int primary key auto_increment,
    name varchar(200) not null,
    phone varchar(11) not null,
    email varchar(100) not null,
    salary decimal(10,2) not null,
    street varchar(100) not null,
    city varchar(100) not null,
    country varchar(100) not null,
    postal_code varchar(8) not null,
    state varchar(20) not null
);