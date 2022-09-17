package com.dev4tech.group2.littlegeniuses.api.model.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserAccountModelResponse {

	@ApiModelProperty(example = "1")
    private Long id;

	@ApiModelProperty(example = "Admin")
    private String name;

    @ApiModelProperty(example = "admin@email.com")
    private String email;

}
