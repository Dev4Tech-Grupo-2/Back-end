package com.dev4tech.group2.littlegeniuses.api.openapi.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.dev4tech.group2.littlegeniuses.api.exceptionhandler.Problem;
import com.dev4tech.group2.littlegeniuses.api.model.request.StudentModelRequest;
import com.dev4tech.group2.littlegeniuses.api.model.response.StudentModelResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Api(tags = "Student")
public interface StudentControllerOpenApi {

	@ApiOperation(value = "List the Students")
	Page<StudentModelResponse> findAll(Pageable pageable);
	
	@ApiOperation(value = "Search for a student by ID")
	@ApiResponses({
		@ApiResponse(responseCode = "400", description = "Invalid student ID",
				content = @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))),
		@ApiResponse(responseCode = "404", description = "Student not found",
				content = @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class)))
	})
	StudentModelResponse findById(
			@ApiParam(value = "ID Student", example = "1",  required = true) Long id);
	
	@ApiOperation(value = "Register a Student")
	@ApiResponses({
		@ApiResponse(responseCode = "201", description = "Registered student")
	})
	StudentModelResponse insert(
			@ApiParam(value = "object", example = "Representation of a new Student",  required = true) StudentModelRequest studentModelRequest);
	
	@ApiOperation(value = "Update a student by ID")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Updated student"),
		@ApiResponse(responseCode = "404", description = "Student not found",
		content = @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class)))
	})
	StudentModelResponse update(
			@ApiParam(value = "ID Student", example = "1", required = true) Long id, 
			@ApiParam(value = "object", example = "Representation of a new Student with new data", required = true) StudentModelRequest studentModelRequest);
	
	@ApiOperation(value = "Delete a student by ID")
	@ApiResponses({
		@ApiResponse(responseCode = "204", description = "Student excluded"),
		@ApiResponse(responseCode = "404", description = "Student not found", 
		content = @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class)))
	})
	void delete(
			@ApiParam(value = "ID Student", example = "1", required = true) Long id);
}
