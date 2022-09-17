package com.dev4tech.group2.littlegeniuses.api.openapi.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.dev4tech.group2.littlegeniuses.api.exceptionhandler.Problem;
import com.dev4tech.group2.littlegeniuses.api.model.request.ClassModelRequest;
import com.dev4tech.group2.littlegeniuses.api.model.request.StudentIdModelRequest;
import com.dev4tech.group2.littlegeniuses.api.model.response.ClassModelResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Api(tags = "Class")
public interface ClassControllerOpenApi {
	
	@ApiOperation(value = "List the classes")
	Page<ClassModelResponse> findAll(Pageable pageable);
	
	@ApiOperation(value = "Search a class by ID")
	@ApiResponses({
		@ApiResponse(responseCode = "400", description = "Invalid class ID",
				content = @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))),
		@ApiResponse(responseCode = "404", description = "Class not found",
				content = @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class)))
	})
	ClassModelResponse findById(
			@ApiParam(value = "ID Class", example = "1", required = true) Long id);
	
	@ApiOperation(value = "Register a class")
	@ApiResponses({
		@ApiResponse(responseCode = "201", description = "Registered class")
	})
	ClassModelResponse insert(
			@ApiParam(value = "body", example = "Representation of a new Class", required = true) ClassModelRequest classModelRequest);
	
	@ApiOperation(value = "Update a class by ID")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Updated class"),
		@ApiResponse(responseCode = "404", description = "Class not found",
		content = @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class)))
	})
	ClassModelResponse update(
			@ApiParam(value = "ID Class", example = "1", required = true) Long id,
			@ApiParam(value = "body", example = "Representation of a new class with new data", required = true) ClassModelRequest classModelRequest);
	
	@ApiOperation(value = "Delete a class by ID")
	@ApiResponses({
		@ApiResponse(responseCode = "204", description = "Class excluded"),
		@ApiResponse(responseCode = "404", description = "Class not found", 
		content = @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class)))
	})
	void delete(
			@ApiParam(value = "ID Class", example = "1", required = true) Long id);
	
	@ApiOperation(value = "Add a Student to the Class by ID")
	void insertStudentInClass(
			@ApiParam(value = "ID Class", example = "1", required = true) Long id, 
			@ApiParam(value = "body", example = "1", required = true) StudentIdModelRequest studentId);
	
	@ApiOperation(value = "Remove a Student to the Class by ID")
	void deleteStudentInClass(
			@ApiParam(value = "ID Class", example = "1", required = true) Long id, 
			@ApiParam(value = "body", example = "ID Student", required = true) StudentIdModelRequest student);
}
