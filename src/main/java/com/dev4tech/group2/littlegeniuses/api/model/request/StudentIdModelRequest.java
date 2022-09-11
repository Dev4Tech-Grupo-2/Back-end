package com.dev4tech.group2.littlegeniuses.api.model.request;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentIdModelRequest {

	@NotNull
	private Long id;
}
