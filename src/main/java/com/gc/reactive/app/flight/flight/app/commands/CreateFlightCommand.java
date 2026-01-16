package com.gc.reactive.app.flight.flight.app.commands;

import com.gc.reactive.app.flight.flight.domain.vos.FlightSegmentData;

import java.util.Set;

public record CreateFlightCommand(
        String airplaneSquare,
        Set<FlightSegmentData> flightSegments)
{
}
