package com.gc.reactive.app.flight.flight.domain.vos;


import java.time.LocalDateTime;

public record FlightSegmentData(
        String airportNameOrigin,
        String airportNameDestination,
        LocalDateTime departureTime,
        LocalDateTime arrivalTime
)
{
}
