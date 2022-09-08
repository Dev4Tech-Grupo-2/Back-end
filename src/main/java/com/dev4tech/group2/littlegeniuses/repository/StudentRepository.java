package com.dev4tech.group2.littlegeniuses.repository;

import com.dev4tech.group2.littlegeniuses.entity.Student;
import com.dev4tech.group2.littlegeniuses.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
