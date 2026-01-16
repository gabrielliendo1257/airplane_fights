package com.gc.reactive.app.flight.booking.presenter.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ContactDto(
        String email,

        @JsonProperty(value = "phone_number")
        String phoneNumber,

        @JsonProperty(value = "first_name")
        String firstName,

        @JsonProperty(value = "last_name")
        String lastName
)
{
}
