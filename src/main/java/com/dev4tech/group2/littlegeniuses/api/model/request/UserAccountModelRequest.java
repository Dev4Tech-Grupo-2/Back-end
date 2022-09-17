package com.dev4tech.group2.littlegeniuses.api.model.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;

@Setter
@Getter
public class UserAccountModelRequest {

    @NotBlank
    @ApiModelProperty(example = "Admin", required = true)
    private String name;

    @Email
    @NotBlank
    @ApiModelProperty(example = "admin@email.com", required = true)
    private String email;

}
