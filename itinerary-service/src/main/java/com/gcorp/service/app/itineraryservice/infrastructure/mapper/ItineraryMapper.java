package com.gcorp.service.app.itineraryservice.infrastructure.mapper;

import com.gcorp.service.app.itineraryservice.domain.models.ItineraryModel;
import com.gcorp.service.app.itineraryservice.infrastructure.entities.ItineraryJpaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItineraryMapper
{
    ItineraryJpaEntity toEntity(ItineraryModel itineraryModel);

    ItineraryModel toModel(ItineraryJpaEntity itineraryEntity);
}
