package com.gc.reactive.app.flight.booking.presenter.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

public record MakeAFlightReservationDto(
        @JsonProperty(required = true, value = "flight_id")
        Integer flightId,
        Set<PassengerDto> passengers,
        PaymentDto payment,
        ContactDto contact
)
{
}
