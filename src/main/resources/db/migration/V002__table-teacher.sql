create table if not exists teacher (
	teacher_id bigint not null auto_increment, 
    city varchar(255) not null, 
    country varchar(255) not null, 
    email varchar(255) not null, 
    name varchar(255) not null, 
    phone varchar(255) not null, 
    postal_code varchar(255) not null, 
    salary decimal(19,2) not null, 
    state varchar(255) not null, 
    street varchar(255) not null, 
    primary key (teacher_id)
) engine=InnoDB;