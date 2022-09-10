package com.dev4tech.group2.littlegeniuses.api.model;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.dev4tech.group2.littlegeniuses.domain.entity.Teacher;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeacherDTO {
	
	private Long id;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String phone;
	
	@NotBlank
	private String email;
	
	@NotNull
	@Positive
	private BigDecimal salary;
	
	@NotBlank
	private String street;
	
	@NotBlank
	private String city;
	
	@NotBlank
	private String country;
	
	@NotBlank
	private String postalCode;
	
	@NotBlank
	private String state;

	public TeacherDTO(Teacher teacher) {
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
