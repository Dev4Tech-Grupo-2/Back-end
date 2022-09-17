package com.dev4tech.group2.littlegeniuses.api.model.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;

@Setter
@Getter
public class UserAccountWithPasswordModelRequest extends UserAccountModelRequest {

    @NotBlank
    @ApiModelProperty(example = "password", required = true)
    private String password;
}
