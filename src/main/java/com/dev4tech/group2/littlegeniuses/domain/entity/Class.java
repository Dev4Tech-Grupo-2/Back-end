package com.dev4tech.group2.littlegeniuses.domain.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Class {

	@Id
	@Column(name = "class_id")
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "grade", nullable = false)
	private String grade;
	
	@OneToOne
	@JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id", nullable = false)
	private Teacher teacher;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "class_student", joinColumns = @JoinColumn(name="class_id"), 
		inverseJoinColumns = @JoinColumn(name="student_id"))
	private Set<Student> students = new HashSet<>();
	
}
