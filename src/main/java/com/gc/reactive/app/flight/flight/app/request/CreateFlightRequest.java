package com.gc.reactive.app.flight.flight.app.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gc.reactive.app.flight.flight.domain.vos.FlightSegmentData;

import java.util.Set;

public record CreateFlightRequest(
        @JsonProperty("airplane_square")
        String airplaneSquare,

        @JsonProperty("flight_segments")
        Set<CreateFlightSegmentRequest> flightSegments
)
{
}
