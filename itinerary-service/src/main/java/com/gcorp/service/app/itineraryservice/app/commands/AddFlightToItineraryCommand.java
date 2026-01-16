package com.gcorp.service.app.itineraryservice.app.commands;

import com.gcorp.service.app.itineraryservice.domain.vos.FlightSegment;

import java.util.Set;

public record AddFlightToItineraryCommand(
        Integer idFlight,
        Set<FlightSegment> segments
)
{
}