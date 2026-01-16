package com.gcorp.service.app.authorizationservice.mapper;

import com.gcorp.service.app.authorizationservice.database.entities.CustomerEntity;
import com.gcorp.service.app.authorizationservice.security.model.CustomerSecurity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper
{
    CustomerSecurity toSecurityAccount(CustomerEntity customerEntity);
}
