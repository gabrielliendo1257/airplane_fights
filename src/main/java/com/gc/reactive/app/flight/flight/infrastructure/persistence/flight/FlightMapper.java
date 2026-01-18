package com.gc.reactive.app.flight.flight.infrastructure.persistence.flight;

import com.gc.reactive.app.flight.flight.domain.models.Flight;
import com.gc.reactive.app.flight.flight.infrastructure.persistence.segments.FlightSegmentMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {FlightSegmentMapper.class})
public interface FlightMapper
{
    FlightJpaEntity toEntity(Flight flightModel);

    Flight toDomain(FlightJpaEntity flightJpaEntity);
}
