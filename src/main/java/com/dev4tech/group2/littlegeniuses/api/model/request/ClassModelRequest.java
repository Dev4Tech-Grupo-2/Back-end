package com.dev4tech.group2.littlegeniuses.api.model.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.dev4tech.group2.littlegeniuses.domain.entity.Teacher;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassModelRequest {

	@NotBlank
	private String grade;
	
	@NotNull
	private Teacher teacher;
}
