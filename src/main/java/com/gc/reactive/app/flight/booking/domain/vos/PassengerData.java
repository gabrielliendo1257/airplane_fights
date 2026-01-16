package com.gc.reactive.app.flight.booking.domain.vos;

import java.time.LocalDateTime;

public record PassengerData(
        String firstName,
        String lastname,
        Document document,
        LocalDateTime birthDate)
{
}
