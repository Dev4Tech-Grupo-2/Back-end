package com.dev4tech.group2.littlegeniuses.api.openapi.model;

import java.util.List;

import com.dev4tech.group2.littlegeniuses.api.model.response.ClassModelResponse;

import io.swagger.annotations.Api;
import lombok.Data;

@Data
@Api("ClassModelResponse")
public class ClassModelOpenApi {
		
	private List<ClassModelResponse> classes;
}
