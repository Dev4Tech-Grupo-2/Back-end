package com.dev4tech.group2.littlegeniuses.api.model.response;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherModelResponse {

	@ApiModelProperty(example = "1")
	private Long id;
	
	@ApiModelProperty(example = "Alex da Silva Brasil")
	private String name;
	
	@ApiModelProperty(example = "11938714876")
	private String phone;
	
	@ApiModelProperty(example = "alex.brasil@email.com.br")
	private String email;
	
	@ApiModelProperty(example = "3200.00")
	private BigDecimal salary;
	
	@ApiModelProperty(example = "R. Joaquim Távora, 1339")
	private String street;
	
	@ApiModelProperty(example = "São Paulo")
	private String city;
	
	@ApiModelProperty(example = "Brasil")
	private String country;
	
	@ApiModelProperty(example = "01415002")
	private String postalCode;
	
	@ApiModelProperty(example = "São Paulo")
	private String state;
}
