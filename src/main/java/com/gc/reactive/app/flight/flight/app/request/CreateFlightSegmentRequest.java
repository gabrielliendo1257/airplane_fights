package com.gc.reactive.app.flight.flight.app.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public record CreateFlightSegmentRequest(
        @JsonProperty(value = "airport_origin")
        String airportNameOrigin,

        @JsonProperty(value = "airport_destination")
        String airportNameDestination,

        @JsonProperty(value = "departure_time")
        LocalDateTime departureTime,

        @JsonProperty(value = "arrival_time")
        LocalDateTime arrivalTime
)
{
}
