package com.gc.reactive.app.flight.flight.app.response;

import com.gc.reactive.app.flight.flight.domain.vos.FlightSegmentData;

import java.util.Set;

public record ItineraryPublicationResult(
        Integer itineraryId,
        Set<FlightSegmentData> segments
) {}
