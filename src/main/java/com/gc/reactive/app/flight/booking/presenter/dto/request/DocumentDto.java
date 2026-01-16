package com.gc.reactive.app.flight.booking.presenter.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gc.reactive.app.flight.booking.utils.enums.DocumentType;

public record DocumentDto(
        @JsonProperty(value = "document_type")
        DocumentType documentType,

        @JsonProperty(value = "document_number")
        String documentNumber)
{
}
