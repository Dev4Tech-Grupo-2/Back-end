package com.dev4tech.group2.littlegeniuses.api.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@ApiModel("Problem")
@JsonInclude(Include.NON_NULL)
public class Problem {

	@ApiModelProperty(example = "400")
	private Integer status;
	
	@ApiModelProperty(example = "https://littlegeniuses.com/invalid-data")
	private String type;
	
	@ApiModelProperty(example = "Invalid data")
	private String title;
	
	@ApiModelProperty(example = "One or more fields are invalid. Please fill in correctly and try again")
	private String detail;
	
	@ApiModelProperty(example = "One or more fields are invalid. Please fill in correctly and try again")
	private String userMessage;
	
	@ApiModelProperty(example = "2022-09-20T20:38:43.455272Z")
	private OffsetDateTime timestamp;
	
	@ApiModelProperty(example= "List of objects or fields that generated the error (optional)")
	private List<Object> objects;
	
	@Getter
	@Builder
	@ApiModel("ObjetoProblema")
	public static class Object {
		
		@ApiModelProperty(example = "Name")
		private String name;
		
		@ApiModelProperty(example = "Name is required")
		private String userMessage;
	}
}
