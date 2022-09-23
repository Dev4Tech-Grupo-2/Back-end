package com.dev4tech.group2.littlegeniuses.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dev4tech.group2.littlegeniuses.domain.entity.Class;

@Repository
public interface ClassRepository extends JpaRepository<Class, Long> {

	@Query("SELECT classe FROM Class classe WHERE classe.grade = :grade AND classe.id != :id")
	Optional<Class> findByGrade(String grade, Long id);
	
	@Query("SELECT classe FROM Class classe WHERE classe.grade = :grade")
	Optional<Class> findByGrade(String grade);
}
