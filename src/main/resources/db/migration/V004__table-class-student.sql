create table if not exists class_student (
	class_id bigint not null, 
    student_id bigint not null,
    foreign key (student_id) references student (student_id),
    foreign key (class_id) references class (class_id),
    constraint `student_class` unique (class_id, student_id)
) engine=InnoDB;
