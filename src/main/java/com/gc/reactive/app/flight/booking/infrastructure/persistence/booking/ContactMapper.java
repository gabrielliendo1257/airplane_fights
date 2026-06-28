package com.gc.reactive.app.flight.booking.infrastructure.mapper;

import com.gc.reactive.app.flight.booking.domain.vos.ContactData;
import com.gc.reactive.app.flight.booking.infrastructure.entities.ContactEmbeddable;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactMapper
{
    ContactEmbeddable toEntity(ContactData contactDto);
}
