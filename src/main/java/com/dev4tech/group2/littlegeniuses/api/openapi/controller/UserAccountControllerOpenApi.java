package com.dev4tech.group2.littlegeniuses.api.openapi.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.dev4tech.group2.littlegeniuses.api.model.request.PasswordModelRequest;
import com.dev4tech.group2.littlegeniuses.api.model.request.UserAccountModelRequest;
import com.dev4tech.group2.littlegeniuses.api.model.request.UserAccountWithPasswordModelRequest;
import com.dev4tech.group2.littlegeniuses.api.model.response.UserAccountModelResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "UserAccount")
public interface UserAccountControllerOpenApi {

	@ApiOperation(value = "List the Users")
	Page<UserAccountModelResponse> findAll(Pageable pageable);
	
	@ApiOperation(value = "Search a User by ID")
	UserAccountModelResponse findById(
			@ApiParam(value = "ID User", example = "1", required = true) Long id);
	
	@ApiOperation(value = "Register a User")
	UserAccountModelResponse insert(
			@ApiParam(value = "body", example = "Representation of a new User", required = true) UserAccountWithPasswordModelRequest userAccountModelRequest);
	
	@ApiOperation(value = "Update a User by ID")
	UserAccountModelResponse update(
			@ApiParam(value = "ID User", example = "1", required = true) Long id, 
			@ApiParam(value = "body", example = "Representation of a new User with new data", required = true) UserAccountModelRequest userAccountModelRequest);
	
	@ApiOperation(value = "Update a password by ID User")
	void changePassword(
			@ApiParam(value = "ID User", example = "1", required = true) Long userId, 
			@ApiParam(value = "body", example = "Representation of a new Password", required = true) PasswordModelRequest password);
	
	@ApiOperation(value = "Delete a User by ID")
	void delete(
			@ApiParam(value = "ID User", example = "1", required = true) Long id);
}
