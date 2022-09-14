package com.dev4tech.group2.littlegeniuses.api.model.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

@Getter
@Setter
public class StudentModelRequest {

    @NotBlank
    @ApiModelProperty(example = "Márcio Martin Fábio Figueiredo", required = true)
    private String name;

    @NotBlank
    @ApiModelProperty(example = "4135172558", required = true)
    private String phone;

    @NotBlank
    @ApiModelProperty(example = "marcio.figueiredo@email.com.br", required = true)
    private String email;

    @NotNull
    @Positive
    @ApiModelProperty(example = "675.00", required = true)
    private BigDecimal fees;

    @NotBlank
    @ApiModelProperty(example = "Rua do Camacuan", required = true)
    private String street;

    @NotBlank
    @ApiModelProperty(example = "Curitiba", required = true)
    private String city;

    @NotBlank
    @ApiModelProperty(example = "Brasil", required = true)
    private String country;

    @NotBlank
    @ApiModelProperty(example = "81550360", required = true)
    private String postalCode;

    @NotBlank
    @ApiModelProperty(example = "Paraná", required = true)
    private String state;

}
