package com.dev4tech.group2.littlegeniuses.api.model.response;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Getter
@Setter
public class StudentModelResponse {

    private Long id;

    private String name;

    private String phone;

    private String email;

    private BigDecimal fees;

    private String street;

    private String city;

    private String country;

    private String postalCode;

    private String state;

}
