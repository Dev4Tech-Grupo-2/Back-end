package com.dev4tech.group2.littlegeniuses.config.security.authorizationserver;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Validated
@Component
@ConfigurationProperties("littlegeniuses.jwt.keystore")
public class JwtKeyStoreProperties {

    @NotNull
    private Resource jksLocation;

    @NotBlank
    private String password;

    @NotBlank
    private String keypairAlias;

}
