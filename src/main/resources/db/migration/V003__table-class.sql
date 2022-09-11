create table if not exists class (
	class_id bigint not null auto_increment, 
    grade varchar(255) not null, 
    teacher_id bigint not null, 
    primary key (class_id),
    foreign key (teacher_id) references teacher (teacher_id)
) engine=InnoDB;