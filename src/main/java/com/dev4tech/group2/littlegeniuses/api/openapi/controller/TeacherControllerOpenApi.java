package com.dev4tech.group2.littlegeniuses.api.openapi.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.dev4tech.group2.littlegeniuses.api.exceptionhandler.Problem;
import com.dev4tech.group2.littlegeniuses.api.model.request.TeacherModelRequest;
import com.dev4tech.group2.littlegeniuses.api.model.response.TeacherModelResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Api(tags = "Teacher")
public interface TeacherControllerOpenApi {

	@ApiOperation(value = "List the teachers")
	Page<TeacherModelResponse> findAll(Pageable pageable);
	
	@ApiOperation(value = "Search a teacher by ID")
	@ApiResponses({
		@ApiResponse(responseCode = "400", description = "Invalid teacher ID",
				content = @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))),
		@ApiResponse(responseCode = "404", description = "Class not found",
				content = @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class)))
	})
	TeacherModelResponse findById(
			@ApiParam(value = "ID Teacher", example = "1", required = true) Long id);
	
	@ApiOperation(value = "Register a teacher")
	@ApiResponses({
		@ApiResponse(responseCode = "201", description = "Registered teacher")
	})
	TeacherModelResponse insert(
			@ApiParam(value = "body", example = "Representation of a new Teacher", required = true) TeacherModelRequest teacherModelRequest);
	
	@ApiOperation(value = "Update a teacher by ID")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Updated teacher"),
		@ApiResponse(responseCode = "404", description = "Class not found",
		content = @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class)))
	})
	TeacherModelResponse update(
			@ApiParam(value = "ID Teacher", example = "1", required = true) Long id, 
			@ApiParam(value = "body", example = "Representation of a new teacher with new data", required = true) TeacherModelRequest teacherModelRequest);
	
	@ApiOperation(value = "Delete a teacher by ID")
	@ApiResponses({
		@ApiResponse(responseCode = "204", description = "Teacher excluded"),
		@ApiResponse(responseCode = "404", description = "Teacher not found", 
		content = @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class)))
	})
	void delete(
			@ApiParam(value = "ID Teacher", example = "1", required = true) Long id);
}
