package com.gc.reactive.app.flight.flight.infrastructure.persistence.segments;

import com.gc.reactive.app.flight.flight.domain.vos.FlightSegmentData;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FlightSegmentMapper
{
    FlightSegmentData toModel(FlightSegmentJpaEntity flightSegmentJpaEntity);

    FlightSegmentJpaEntity toEntity(FlightSegmentData flightSegment);
}
