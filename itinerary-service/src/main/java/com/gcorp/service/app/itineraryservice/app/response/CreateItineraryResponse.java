package com.gcorp.service.app.itineraryservice.app.response;

import com.gcorp.service.app.itineraryservice.domain.vos.FlightSegment;

import java.util.Set;

public record CreateItineraryResponse(
        Integer itineraryId,
        Set<FlightSegment> segments
) {}
