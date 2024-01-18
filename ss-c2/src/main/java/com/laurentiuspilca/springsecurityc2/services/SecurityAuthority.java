package com.laurentiuspilca.springsecurityc2.services;

import com.laurentiuspilca.springsecurityc2.entities.Authority;
import org.springframework.security.core.GrantedAuthority;


public class SecurityAuthority implements GrantedAuthority {

    private final Authority authority;

    public SecurityAuthority(Authority authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority.getName();
    }
}
