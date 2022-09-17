package com.dev4tech.group2.littlegeniuses.api.model.request;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherModelRequest {
	
	@NotBlank
	@ApiModelProperty(example = "Alex da Silva Brasil", required = true)
	private String name;
	
	@NotBlank
	@ApiModelProperty(example = "11938714876", required = true)
	private String phone;
	
	@NotBlank
	@ApiModelProperty(example = "alex.brasil@email.com.br", required = true)
	private String email;
	
	@NotNull
	@Positive
	@ApiModelProperty(example = "3200.00", required = true)
	private BigDecimal salary;
	
	@NotBlank
	@ApiModelProperty(example = "R. Joaquim Távora, 1339", required = true)
	private String street;
	
	@NotBlank
	@ApiModelProperty(example = "São Paulo", required = true)
	private String city;
	
	@NotBlank
	@ApiModelProperty(example = "Brasil", required = true)
	private String country;
	
	@NotBlank
	@ApiModelProperty(example = "01415002", required = true)
	private String postalCode;
	
	@NotBlank
	@ApiModelProperty(example = "São Paulo", required = true)
	private String state;
}
