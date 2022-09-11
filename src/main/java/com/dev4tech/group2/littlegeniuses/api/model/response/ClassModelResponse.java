package com.dev4tech.group2.littlegeniuses.api.model.response;

import java.util.HashSet;
import java.util.Set;

import com.dev4tech.group2.littlegeniuses.domain.entity.Student;
import com.dev4tech.group2.littlegeniuses.domain.entity.Teacher;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassModelResponse {

	private Long id;
	
	private String grade;
	
	private Teacher teacher;
	
	private Set<Student> students = new HashSet<>();
	
}
