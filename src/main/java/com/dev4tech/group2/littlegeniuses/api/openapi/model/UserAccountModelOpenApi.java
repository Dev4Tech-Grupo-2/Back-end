package com.dev4tech.group2.littlegeniuses.api.openapi.model;

import java.util.List;

import com.dev4tech.group2.littlegeniuses.api.model.response.UserAccountModelResponse;

import io.swagger.annotations.Api;
import lombok.Data;

@Data
@Api("UserAccountModelResponse")
public class UserAccountModelOpenApi {
	
	private List<UserAccountModelResponse> users;
}
