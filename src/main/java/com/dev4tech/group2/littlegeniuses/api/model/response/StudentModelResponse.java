package com.dev4tech.group2.littlegeniuses.api.model.response;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

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
