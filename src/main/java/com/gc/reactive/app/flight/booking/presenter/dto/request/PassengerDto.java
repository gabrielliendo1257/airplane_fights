package com.gc.reactive.app.flight.booking.presenter.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public record PassengerDto(
        @JsonProperty(value = "first_name")
        String firstName,

        @JsonProperty(value = "last_name")
        String lastName,

        DocumentDto document,

        @JsonProperty(value = "birth_date")
        LocalDateTime birthDate
)
{
}
