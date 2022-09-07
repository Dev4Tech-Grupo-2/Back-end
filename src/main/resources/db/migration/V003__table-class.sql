create table class(
	id int primary key auto_increment,
    grade varchar(50) not null,
    teacher_id int not null,
    student_id int not null,
    foreign key (teacher_id) references teacher(id),
    foreign key (student_id) references student(id),
    constraint `teacher_student` unique (teacher_id, student_id)
);