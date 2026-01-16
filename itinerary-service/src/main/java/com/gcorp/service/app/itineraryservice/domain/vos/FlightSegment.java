package com.gcorp.service.app.itineraryservice.domain.vos;

import java.time.LocalDateTime;

public record FlightSegment(
        String departureAirportName,
        String arrivalAirportName,
        LocalDateTime departureTime,
        LocalDateTime arrivalTime
)
{
}
