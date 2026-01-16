package com.gc.reactive.app.flight.flight.infrastructure.mapper;

import com.gc.reactive.app.flight.flight.domain.vos.FlightSegmentData;
import com.gc.reactive.app.flight.flight.infrastructure.entities.FlightSegmentJpaEntity;
import org.mapstruct.Mapper;

@Mapper
public interface FlightSegmentMapper
{
    FlightSegmentData toModel(FlightSegmentJpaEntity flightSegmentJpaEntity);

    FlightSegmentJpaEntity toEntity(FlightSegmentData flightSegment);
}
