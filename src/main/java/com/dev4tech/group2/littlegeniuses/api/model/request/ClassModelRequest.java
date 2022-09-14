package com.dev4tech.group2.littlegeniuses.api.model.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassModelRequest {

	@NotBlank
	@ApiModelProperty(example = "1ª série")
	private String grade;
	
	@NotNull
	@ApiModelProperty(example = "1")
	private Long teacherId;
}
