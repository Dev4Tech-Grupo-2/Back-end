package com.dev4tech.group2.littlegeniuses.config.security.authorizationserver;

import com.dev4tech.group2.littlegeniuses.domain.entity.UserAccount;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
public class AuthUser extends User {

    private Long userId;
    private String fullName;

    public AuthUser(UserAccount user, Collection<GrantedAuthority> authorities) {
        super(user.getEmail(), user.getPassword(), authorities);

        this.userId = user.getId();
        this.fullName = user.getName();
    }

}
