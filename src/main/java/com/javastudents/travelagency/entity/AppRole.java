package com.javastudents.travelagency.entity;

import org.springframework.security.core.GrantedAuthority;

public enum  AppRole implements GrantedAuthority {

    ROLE_SUPER,
    ROLE_APP_ADMIN ,
    ROLE_TRAVEL_AGENT ,
    ROLE_USER ;

    @Override
    public String getAuthority() {
        return getAppRoleFromIndex();
    }

    public String getAppRoleFromIndex() {
        switch (ordinal()){
            case 0:
                return String.valueOf(AppRole.ROLE_SUPER);
            case 1:
                return String.valueOf(AppRole.ROLE_APP_ADMIN);
            case 2:
                return String.valueOf(AppRole.ROLE_TRAVEL_AGENT);
            case 3:
                return String.valueOf(AppRole.ROLE_USER);
        }
        return null;
    }
}
