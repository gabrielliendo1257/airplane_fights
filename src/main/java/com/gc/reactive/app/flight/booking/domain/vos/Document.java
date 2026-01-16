package com.gc.reactive.app.flight.booking.domain.vos;

import com.gc.reactive.app.flight.booking.utils.enums.DocumentType;

public record Document(DocumentType documentType, String number)
{
    public Document
    {
        if (documentType == DocumentType.DNI && !number.matches("\\d{8}"))
        {
            throw new IllegalArgumentException("Invalid document number");
        }
    }
}
