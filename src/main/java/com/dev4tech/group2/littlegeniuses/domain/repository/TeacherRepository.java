package com.dev4tech.group2.littlegeniuses.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dev4tech.group2.littlegeniuses.domain.entity.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

	@Query("SELECT t FROM Teacher t INNER JOIN Class c ON c.teacher.id = t.id WHERE t.id = :idTeacher AND c.id != :idClass")
	Optional<Teacher> findByTeacherClass(Long idTeacher, Long idClass);
	
	@Query("SELECT t FROM Teacher t INNER JOIN Class c ON c.teacher.id = t.id WHERE t.id = :idTeacher")
	Optional<Teacher> findByTeacherClass(Long idTeacher);
	
	@Query("SELECT t FROM Teacher t WHERE t.email = :email")
	Optional<Teacher> findByEmail(String email);
	
	@Query("SELECT t FROM Teacher t WHERE t.email = :email AND t.id != :id")
	Optional<Teacher> findByEmail(String email, Long id);
}
