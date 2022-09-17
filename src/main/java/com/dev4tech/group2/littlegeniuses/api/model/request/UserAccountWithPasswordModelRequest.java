package com.dev4tech.group2.littlegeniuses.api.model.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class UserAccountWithPasswordModelRequest extends UserAccountModelRequest {

    @NotBlank
    private String password;
}
