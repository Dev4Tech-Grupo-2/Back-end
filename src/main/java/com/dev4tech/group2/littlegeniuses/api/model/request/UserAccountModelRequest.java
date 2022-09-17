package com.dev4tech.group2.littlegeniuses.api.model.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class UserAccountModelRequest {

    @NotBlank
    private String name;

    @Email
    @NotBlank
    private String email;

}
