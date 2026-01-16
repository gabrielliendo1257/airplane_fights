package com.gcorp.service.app.authorizationservice.util.enums;

import lombok.Getter;

import java.util.Set;

public enum Role
{
    ADMIN(Set.of(Authority.CREATE_CUSTOMER,
            Authority.DELETE_CUSTOMER,
            Authority.READ_CUSTOMER,
            Authority.UPDATE_CUSTOMER)),
    CUSTOMER(Set.of(Authority.CREATE_CUSTOMER,
            Authority.UPDATE_CUSTOMER));

    @Getter
    private final Set<Authority> authorities;

    Role(Set<Authority> authorities)
    {
        this.authorities = authorities;
    }
}
