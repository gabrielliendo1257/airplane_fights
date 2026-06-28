package com.gcorp.service.app.bookingservice.infrastructure.components.passenger;

public record PassengerRequestDto(
        String firstName,
        String lastName,
        String documentNumber
) {
}
