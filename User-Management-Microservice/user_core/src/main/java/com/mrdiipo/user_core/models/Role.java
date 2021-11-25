package com.mrdiipo.user_core.models;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    READ_READ_PRIVILEDGE, WRITE_PRIVILEDGE;

    @Override
    public String getAuthority() {
        return name();
    }
}
