package com.dev4tech.group2.littlegeniuses.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev4tech.group2.littlegeniuses.domain.entity.Class;

@Repository
public interface ClassRepository extends JpaRepository<Class, Long> {

}
