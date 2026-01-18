package com.gc.reactive.app.flight.flight.app.commands;

import com.gc.reactive.app.flight.flight.app.request.CreateFlightRequest;
import com.gc.reactive.app.flight.flight.domain.vos.FlightSegmentData;

import java.util.Set;
import java.util.stream.Collectors;

public record CreateFlightCommand(
        String airplaneSquare,
        Set<FlightSegmentData> flightSegments)
{
    public static CreateFlightCommand from(CreateFlightRequest request) {
        Set<FlightSegmentData> segments = request.flightSegments()
                .stream()
                .map(flightSegment -> new FlightSegmentData(
                        flightSegment.airportNameOrigin(),
                        flightSegment.airportNameDestination(),
                        flightSegment.departureTime(),
                        flightSegment.arrivalTime()
                ))
                .collect(Collectors.toSet());

        return new CreateFlightCommand(
                request.airplaneSquare(),
                segments
        );
    }
}
