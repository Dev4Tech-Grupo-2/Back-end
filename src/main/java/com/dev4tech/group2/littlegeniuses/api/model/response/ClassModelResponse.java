package com.dev4tech.group2.littlegeniuses.api.model.response;

import java.util.HashSet;
import java.util.Set;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassModelResponse {

	@ApiModelProperty(example = "1")
	private Long id;
	
	@ApiModelProperty(example = "1ª série")
	private String grade;
	
	private TeacherModelResponse teacher;
	
	private Set<StudentModelResponse> students = new HashSet<>();
	
}
