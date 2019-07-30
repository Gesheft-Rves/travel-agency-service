package com.javastudents.travelagency.entity;

import org.springframework.security.core.GrantedAuthority;

public enum  Role implements GrantedAuthority {

    ROLE_SUPER,
    ROLE_APP_ADMIN ,
    ROLE_TRAVEL_AGENT;

    @Override
    public String getAuthority() {
        return name();
    }
}
