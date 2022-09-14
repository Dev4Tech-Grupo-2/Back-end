package com.dev4tech.group2.littlegeniuses.api.openapi.model;

import java.util.List;

import com.dev4tech.group2.littlegeniuses.api.model.response.TeacherModelResponse;

import io.swagger.annotations.Api;
import lombok.Data;

@Data
@Api("TeacherModelResponse")
public class TeacherModelOpenApi {

	private List<TeacherModelResponse> teachers;
}
