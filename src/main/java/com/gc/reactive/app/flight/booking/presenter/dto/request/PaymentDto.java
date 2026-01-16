package com.gc.reactive.app.flight.booking.presenter.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PaymentDto(
        @JsonProperty(value = "card_token")
        String cardToken
)
{
}
