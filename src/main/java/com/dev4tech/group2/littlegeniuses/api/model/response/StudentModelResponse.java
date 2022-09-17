package com.dev4tech.group2.littlegeniuses.api.model.response;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentModelResponse {

	@ApiModelProperty(example = "1")
    private Long id;

	@ApiModelProperty(example = "Márcio Martin Fábio Figueiredo")
    private String name;

	@ApiModelProperty(example = "4135172558")
    private String phone;

	@ApiModelProperty(example = "marcio.figueiredo@email.com.br")
    private String email;

	@ApiModelProperty(example = "675.00")
    private BigDecimal fees;

	@ApiModelProperty(example = "Rua do Camacuan")
    private String street;

	@ApiModelProperty(example = "Curitiba")
    private String city;

	@ApiModelProperty(example = "Brasil")
    private String country;

	@ApiModelProperty(example = "81550360")
    private String postalCode;

	@ApiModelProperty(example = "Paraná")
    private String state;

}
