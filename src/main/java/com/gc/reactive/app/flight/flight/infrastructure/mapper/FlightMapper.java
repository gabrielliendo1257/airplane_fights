package com.gc.reactive.app.flight.flight.infrastructure.mapper;

import com.gc.reactive.app.flight.flight.domain.models.Flight;
import com.gc.reactive.app.flight.flight.infrastructure.entities.FlightJpaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {FlightSegmentMapper.class})
public interface FlightMapper
{
    FlightJpaEntity toEntity(Flight flightModel);

    Flight toDomain(FlightJpaEntity flightJpaEntity);
}
