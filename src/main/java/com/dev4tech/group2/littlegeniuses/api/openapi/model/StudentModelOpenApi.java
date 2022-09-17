package com.dev4tech.group2.littlegeniuses.api.openapi.model;

import java.util.List;

import com.dev4tech.group2.littlegeniuses.api.model.response.StudentModelResponse;

import io.swagger.annotations.Api;
import lombok.Data;

@Data
@Api("StudentModelResponse")
public class StudentModelOpenApi {

	private List<StudentModelResponse> students;
}
