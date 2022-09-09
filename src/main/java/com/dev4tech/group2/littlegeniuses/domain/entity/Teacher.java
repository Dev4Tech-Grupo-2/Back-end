package com.dev4tech.group2.littlegeniuses.domain.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.dev4tech.group2.littlegeniuses.api.dto.TeacherDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Teacher {

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "phone", nullable = false)
	private String phone;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "salary", nullable = false)
	private BigDecimal salary;
	
	@Column(name = "street", nullable = false)
	private String street;
	
	@Column(name = "city", nullable = false)
	private String city;
	
	@Column(name = "country", nullable = false)
	private String country;
	
	@Column(name = "postal_code", nullable = false)
	private String postalCode;
	
	@Column(name = "state", nullable = false)
	private String state;
	
	public Teacher(TeacherDTO teacher) {
		this.id = teacher.getId();
		this.name = teacher.getName();
		this.phone = teacher.getPhone();
		this.email = teacher.getEmail();
		this.salary = teacher.getSalary();
		this.street = teacher.getStreet();
		this.city = teacher.getCity();
		this.country = teacher.getCountry();
		this.postalCode = teacher.getPostalCode();
		this.state = teacher.getState();
	}
}
