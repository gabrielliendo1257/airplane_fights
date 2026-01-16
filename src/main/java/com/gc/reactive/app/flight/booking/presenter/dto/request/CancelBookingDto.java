package com.gc.reactive.app.flight.booking.presenter.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record CancelBookingDto
        (
                @Size(min = 5, max = 20)
                @NotEmpty
                @NotBlank
                String code,

                @Size(min = 5, max = 20)
                @NotEmpty
                @NotBlank
                @JsonProperty(value = "last_name")
                String lastName
        )
{
}
