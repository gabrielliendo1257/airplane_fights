package com.gc.reactive.app.flight.flight.infrastructure.itinerary.client;

import com.gc.reactive.app.flight.flight.domain.vos.FlightSegmentData;

import java.util.Set;

public record AddFlightToItineraryDto(
        Integer idFlight,
        Set<FlightSegmentData> segments
)
{
}
